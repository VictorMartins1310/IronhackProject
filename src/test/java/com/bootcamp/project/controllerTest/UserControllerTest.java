package com.bootcamp.project.controllerTest;

import static org.mockito.Mockito.when;
import com.bootcamp.project.controller.implement.UserControllerImpl;
import com.bootcamp.project.dto.LoginDTO;
import com.bootcamp.project.dto.UserDetailsDTO;
import com.bootcamp.project.mappers.UserDetailsMapper;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc
@WebMvcTest(UserControllerImpl.class)
public class UserControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private WebApplicationContext webApplicationContext;

    @MockBean private UserService userService;
    @MockBean private UserDetailsMapper userDetailsMapper;
    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @DisplayName("Test: Adding new Users")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testCreateUser() throws Exception {
        User user = new User("email@mail.com", "PassWORTd");
        UserDetailsDTO userDto = new UserDetailsDTO();
        LoginDTO loginDto = new LoginDTO();
        userDto.setEmail(user.getEmail()); userDto.setEmail(user.getPassword());
        loginDto.setEmail(user.getEmail()); loginDto.setEmail(user.getPassword());

        when(userDetailsMapper.toDto(userService.newUser("email@mail.com", "PassWORTd"))).thenReturn(userDto);

        mockMvc.perform(
                post("/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginDto)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(userDto))); //https://github.com/json-path/JsonPath
    }
    @DisplayName("Test: Update UsersDetails")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testUpdateUser() throws Exception {
        String email = "User@mail.de",
                pass = "pass1234";
        UUID uuid = UUID.randomUUID();

        User userA = new User(email, pass);
        userA.setUserID(uuid);


        UserDetailsDTO userIn = new UserDetailsDTO();
        userIn.setEmail(email);
        userIn.setFirstName("Victor");
        userIn.setLastName("Martins");
        userIn.setBirthDate("1987-10-13");


        UserDetailsDTO userOut = new UserDetailsDTO();
        userOut.setEmail(email);
        userOut.setFirstName("Victor");
        userOut.setLastName("Martins");
        userOut.setBirthDate("1987-10-13");

        System.out.println(objectMapper.writeValueAsString(userA));
        System.out.println(objectMapper.writeValueAsString(userIn));
        System.out.println(objectMapper.writeValueAsString(userOut));

        when(userDetailsMapper.toDto(userService.updateDetails(uuid, userA))).thenReturn(userOut);

        mockMvc.perform(
                        patch("/users/register/detailsT") // Adapted because got Trouble with logged user
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(userA)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(userOut))); //https://github.com/json-path/JsonPath
    }
}