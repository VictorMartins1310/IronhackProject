package com.bootcamp.project.controller;

import com.bootcamp.project.controller.implement.TaskListControllerImpl;
import com.bootcamp.project.dto.TaskListDTO;
import com.bootcamp.project.mappers.TaskListMapper;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.repos.RoleRepository;
import com.bootcamp.project.repos.UserRepository;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@WebMvcTest(TaskListControllerImpl.class)
public class TaskListControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private WebApplicationContext webApplicationContext;

    @MockBean private UserRepository userRepository;
    @MockBean private RoleRepository roleRepository;
    @MockBean private PasswordEncoder passwordEncoder;
    @MockBean private TaskListMapper taskListMapper;
    @MockBean private TaskListService taskListService;
    @MockBean private UserService userService;


    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @DisplayName("Test: Get All Task Lists")
    @WithMockUser(username = "testUser", roles = {"USER"})
    @Test public void testGetAllTaskLists() throws Exception {
        User user = new User("User@mail.de", "pass1234");
        TaskList taskList = new TaskList("TaskLIst Test", user);

        List<TaskListDTO> taskLists = new ArrayList<>();
        taskLists.add(taskListMapper.toDto(taskList));

        when(taskListMapper.toDtos(taskListService.getTaksListsbyUser(user))).thenReturn(taskLists);

        mockMvc.perform(get("/todolist/tasklist"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(taskLists)));
    }
    @DisplayName("Test: Create Task List")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testCreateTaskList() throws Exception {
        User user = new User();
        when(taskListService.newTaskList(any(), any())).thenReturn(new TaskList());

        // TODO
   /*     mockMvc.perform(post("/todolist/tasklists")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString()))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.totalPrice").value() //https://github.com/json-path/JsonPath
                .andExpect(content().json(objectMapper.writeValueAsString()));
*/
    }
    @DisplayName("Test: Update Task List")
    @WithMockUser(username = "testUser", roles = {"USER"})
    @Test public void testUpdateTaskList() throws Exception {
        String tklname = "Test";

        User user = new User("email@mail.com", "DumpPass1234");
        Long id = 13L;

        TaskList taskList1 = new TaskList("TASK LIST TODO", user);
        taskList1.setTodoListID(id);

        TaskList taskList2 = new TaskList(tklname, user);
        taskList2.setTodoListID(id);

        when(taskListService.updateTaskList(id, tklname)).thenReturn(taskList2);
        mockMvc.perform(patch("/todolist/tasklist/{id}", id.toString())
                        .queryParam("tklname", tklname))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(taskList2)));
    }
}