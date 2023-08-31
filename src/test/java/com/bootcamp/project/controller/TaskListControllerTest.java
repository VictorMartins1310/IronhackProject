package com.bootcamp.project.controller;

import com.bootcamp.project.controller.implement.TaskListControllerImpl;
import com.bootcamp.project.dto.TaskListDTO;
import com.bootcamp.project.mappers.TaskListMapper;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@WebMvcTest(TaskListControllerImpl.class)
public class TaskListControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private WebApplicationContext webApplicationContext;

    @MockBean private TaskListMapper taskListMapper;
    @MockBean private TaskListService taskListService;
    @MockBean private UserService userService;


    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @WithMockUser(username = "testUser", roles = {"USER"})
    @Test public void testGetAllTaskLists() throws Exception {
        User user = new User("User@mail.de", "pass1234");
        userService.newUser("User@mail.de", "pass1234");
        TaskList taskList = new TaskList("TaskLIst Test", user);
        userService.loadUserByUsername("User@mail.de");

        List<TaskListDTO> taskLists = new ArrayList<>();
        taskLists.add(taskListMapper.toDto(taskList));


        when(taskListMapper.toDtos(taskListService.getTaksListsbyUser(user))).thenReturn(taskLists);

        mockMvc.perform(get("/todolist/tasklist"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(taskLists)));
    }
/*    @Test public void testCreate() throws Exception {
        when(taskListService.createOrder(any())).thenReturn(savedOrderDto);

        mockMvc.perform(post("/api/v1/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.totalPrice").value(BigDecimal.TEN)) //https://github.com/json-path/JsonPath
                .andExpect(content().json(objectMapper.writeValueAsString(savedOrderDto)));
    }
*/
}