package com.bootcamp.project.controllerTest;

import com.bootcamp.project.controller.implement.AdminController;
import com.bootcamp.project.dto.UserDetailsDTO;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(AdminController.class)
public class AdminControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private WebApplicationContext webApplicationContext;

    @MockBean private UserService userService;

    @BeforeEach public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @DisplayName("Test: Get All Users")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testGetAllUsers() throws Exception {
        List<User> users = new ArrayList<>();
        users.add(new User("Admin@mail.de","badPassword"));
        users.add(new User("User@mail.de", "badPassword"));

        when(userService.showUsers()).thenReturn(users);

        mockMvc.perform(get("/admin/users"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(users)));
    }
    @DisplayName("Test: Delete Users")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testDeleteUser() throws Exception {
        String email = "User@mail.de",
                pass = "pass1234";
        UUID uuid = UUID.randomUUID();

        User userA = new User(email, pass);
        userA.setUserID(uuid);
        UserDetailsDTO userB = new UserDetailsDTO();
        userB.setEmail(email);

        System.out.println(objectMapper.writeValueAsString(userA));

        when(userService.deleteUserByID(uuid)).thenReturn(true);

        mockMvc.perform(
                        delete("/admin/users/{uuid}", uuid.toString()))
                .andExpect(status().isNoContent());
    }
}