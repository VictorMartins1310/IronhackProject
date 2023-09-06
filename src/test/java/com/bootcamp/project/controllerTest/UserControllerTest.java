package com.bootcamp.project.controllerTest;

import com.bootcamp.project.controller.implement.UserControllerImpl;
import com.bootcamp.project.dto.LoginDTO;
import com.bootcamp.project.dto.UserDetailsDTO;
import com.bootcamp.project.mappers.UserDetailsMapper;
import com.bootcamp.project.model.Role;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc
@WebMvcTest(UserControllerImpl.class)
public class UserControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private WebApplicationContext webApplicationContext;

    @MockBean private UserService userService;
    @MockBean private UserDetailsMapper userDetailsMapper;

    private final LocalDate birthdate = LocalDate.parse("1987-10-13");
    private final String
            firstName = "Victor",
            lastName = "Martins";

    private final User userIN = new User("email@mail.com", "Test.1234");
    private final Role role = new Role();
    private final UUID userID = UUID.randomUUID();


    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        role.setRole("USER_ROLE");

        userIN.setFirstName(firstName);
        userIN.setLastName(lastName);
        userIN.setBirthDate(birthdate);
        userIN.addRole(role);
    }

    @DisplayName("Test: Adding new Users")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testCreateUser() throws Exception {
        UserDetailsDTO userDto = new UserDetailsDTO();
        LoginDTO loginDto = new LoginDTO();
        userDto.setEmail(userIN.getEmail()); userDto.setEmail(userIN.getPassword());
        loginDto.setEmail(userIN.getEmail()); loginDto.setEmail(userIN.getPassword());

        when(userDetailsMapper.toDto(userService.newUser("email@mail.com", "PassWORTd"))).thenReturn(userDto);

        mockMvc.perform(
                post("/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginDto)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(userDto))); //https://github.com/json-path/JsonPath
    }

    @DisplayName("Test: Get UsersDetails")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void getUserDetails() throws Exception {
        UserDetailsDTO userOut = new UserDetailsDTO();
        userOut.setEmail(userIN.getEmail());
        userOut.setFirstName(firstName);
        userOut.setLastName(lastName);
        userOut.setBirthDate(birthdate);


        when(userDetailsMapper.toDto(userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()))).thenReturn(userOut);

        mockMvc.perform(
                        get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(userOut))); //https://github.com/json-path/JsonPath
    }

    @DisplayName("Test: Update UsersDetails on Register")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testUpdateUser() throws Exception{
        String email = userIN.getEmail();

        UserDetailsDTO userInDto = new UserDetailsDTO();
        userInDto.setEmail(email);
        userInDto.setBirthDate(birthdate);

        UserDetailsDTO userOutDto = new UserDetailsDTO();
        userOutDto.setEmail(email);
        userOutDto.setFirstName(firstName);
        userOutDto.setLastName(lastName);
        userOutDto.setBirthDate(birthdate);

        when(userDetailsMapper.toDto(userService.updateDetails(userIN, userInDto.getFirstName(), userInDto.getLastName(), userInDto.getBirthDate().toString()))).thenReturn(userOutDto);

        mockMvc.perform(
                        patch("/users/register/details") // Adapted because got Trouble with logged user
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(userInDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(userOutDto))); //https://github.com/json-path/JsonPath
    }
}