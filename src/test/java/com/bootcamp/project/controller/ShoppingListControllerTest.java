package com.bootcamp.project.controller;

import com.bootcamp.project.controller.implement.ShoppingListControllerImpl;
import com.bootcamp.project.mappers.ShoppingListMapper;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.ShoppingListService;
import com.bootcamp.project.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@AutoConfigureMockMvc
@WebMvcTest(ShoppingListControllerImpl.class)
public class ShoppingListControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private WebApplicationContext webApplicationContext;

    @MockBean private ShoppingListService shoppingListService;
    @MockBean private UserService userService;
    @MockBean private ShoppingListMapper shoppingListMapper;
    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test public void testGetAllShoppingLists() throws Exception {
        User user = new User("User@mail.de", "badPassword");
        List<ShoppingList> shoppingLists = new ArrayList<>();

        when(shoppingListService.getShoppingLists(user)).thenReturn(shoppingLists);

        mockMvc.perform(get("/todolist/shoppinglist"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(shoppingLists)));
    }
/*    @Test public void testCreate() throws Exception {
        when(shoppingListService.createOrder(any())).thenReturn(savedOrderDto);

        mockMvc.perform(post("/api/v1/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.totalPrice").value(BigDecimal.TEN)) //https://github.com/json-path/JsonPath
                .andExpect(content().json(objectMapper.writeValueAsString(savedOrderDto)));
    }
*/
}
