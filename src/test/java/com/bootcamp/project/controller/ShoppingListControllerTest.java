package com.bootcamp.project.controller;

import com.bootcamp.project.controller.implement.ShoppingListControllerImpl;
import com.bootcamp.project.service.ShoppingListService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(ShoppingListControllerImpl.class)
public class ShoppingListControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private WebApplicationContext webApplicationContext;

    @Autowired private ShoppingListService shoppingListService;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
/*
    @Test
    public void testGetAll() throws Exception {

        when(shoppingListService.getAllOrders()).thenReturn(orderDtos);

        mockMvc.perform(get("/api/v1/orders"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(orderDtos)));
    }
    @Test public void testCreate() throws Exception {
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
