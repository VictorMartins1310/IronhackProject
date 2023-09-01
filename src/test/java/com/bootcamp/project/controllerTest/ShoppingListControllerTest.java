package com.bootcamp.project.controllerTest;

import com.bootcamp.project.controller.implement.ShoppingListControllerImpl;
import com.bootcamp.project.dto.ShoppingListDTO;
import com.bootcamp.project.mappers.ShoppingListMapper;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.ShoppingListService;
import com.bootcamp.project.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@AutoConfigureMockMvc
@WebMvcTest(ShoppingListControllerImpl.class)
public class ShoppingListControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private WebApplicationContext webApplicationContext;

    @MockBean private ShoppingListService shoppingListService;
    @MockBean private  UserService userService;
    @MockBean private ShoppingListMapper shoppingLMapper;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @DisplayName("Test: Create Shopping List")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testCreateShoppingList() throws Exception {
        Long shopID = 1L;
        User user = new User("User@mail.de", "badPassword");

        String shopname = "Test";

        ShoppingList shoppingList = new ShoppingList(user, shopname);
        shoppingList.setTodoListID(shopID);

        ShoppingListDTO shoppingListDTO1 = new ShoppingListDTO();
        shoppingListDTO1.setMarketName(shopname);
        shoppingListDTO1.setTodoListName(shoppingList.getTodoListName());

        ShoppingListDTO shoppingListDTO2 = new ShoppingListDTO();
        shoppingListDTO2.setMarketName(shopname);
        shoppingListDTO2.setTodoListName(shoppingList.getTodoListName());


        when(shoppingLMapper.toDto(shoppingListService.newShoppingList(user, shopname))).thenReturn(shoppingListDTO1);
        System.out.println(objectMapper.writeValueAsString(shoppingList));
        System.out.println(objectMapper.writeValueAsString(shoppingListDTO1));
        System.out.println(objectMapper.writeValueAsString(shoppingListDTO2));
        mockMvc.perform(post("/todolist/shoppinglist")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(shoppingListDTO1)))

                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(shoppingListDTO2)));
    }
    @DisplayName("Test: Get All Shoppinglists")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testGetAllShoppingLists() throws Exception {
        Long shopID = 13L;
        User user = new User("User@mail.de", "badPassword");

        String shopname = "Test";

        ShoppingList shoppingList = new ShoppingList(user, shopname);
        shoppingList.setTodoListID(shopID);
        List<ShoppingList> shoppingLists = new ArrayList<>();
        shoppingLists.add(shoppingList);

        ShoppingListDTO shoppingListDTO = new ShoppingListDTO();
        shoppingListDTO.setMarketName(shopname);
        List<ShoppingListDTO> shoppingListDTOs = new ArrayList<>();
        shoppingLists.add(shoppingList);


        when(shoppingListService.getShoppingLists(user)).thenReturn(shoppingLists);

        mockMvc.perform(get("/todolist/shoppinglist"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(shoppingListDTOs)));
    }

    // TODO Implemente Update
}