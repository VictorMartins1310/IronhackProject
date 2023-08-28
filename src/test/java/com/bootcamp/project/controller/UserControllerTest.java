package com.bootcamp.project.controller;

import com.bootcamp.project.controller.implement.UserControllerImpl;
import com.bootcamp.project.dto.UserDetailsDTO;
import com.bootcamp.project.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(UserControllerImpl.class)
public class UserControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private WebApplicationContext webApplicationContext;

    @Autowired private UserService userService;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test public void testCreateUser() throws Exception {
        UserDetailsDTO userDto = new UserDetailsDTO();
        /*
        when(userService.newUser("email@mail", "PassWORTd")).thenReturn(userDto);

        mockMvc.perform(post("/api/v1/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.totalPrice").value(BigDecimal.TEN)) //https://github.com/json-path/JsonPath
                .andExpect(content().json(objectMapper.writeValueAsString(savedOrderDto)));
    */
    }
}