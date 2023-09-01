package com.bootcamp.project.controllerTest;

import com.bootcamp.project.controller.implement.TaskListControllerImpl;
import com.bootcamp.project.dto.TaskListDTO;
import com.bootcamp.project.mappers.TaskListMapper;
import com.bootcamp.project.model.Role;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    @MockBean private TaskListMapper taskListMapper;
    @MockBean private TaskListService taskListService;
    @MockBean private UserService userService;


    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @DisplayName("Test: Create Task List")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testCreateTaskList() throws Exception {
        User user = new User("email@mail.com", "DumpPass1234");
        Role role = new Role();
        role.setRoleID(1);
        role.setRole("USER");
        user.addRole(role);
        Long id = 13L;
        user.setUserID(UUID.randomUUID());
        Date date = new Date();
        String todoListName1 = "TASK LIST TODO";
        String todoListName2 = "NEW TASK LIST NAME";
        TaskList taskList1 = new TaskList(todoListName1, user);
        TaskList taskList2 = new TaskList(todoListName2, user);

        TaskListDTO taskListDTOIN = new TaskListDTO();
        taskListDTOIN.setTodoListName(todoListName1);
        TaskListDTO taskListDTOOUT = new TaskListDTO();
        taskListDTOIN.setTodoListName(todoListName2);

        taskList1.setTodoListID(id);
        taskList2.setTodoListID(id);
        taskList1.setCreationDate(date);
        taskList2.setCreationDate(date);
        taskList1.setTasks(new ArrayList<>());
        taskList2.setTasks(new ArrayList<>());

        System.out.println(objectMapper.writeValueAsString(taskList1));
        System.out.println(objectMapper.writeValueAsString(taskList2));
        System.out.println(objectMapper.writeValueAsString(taskListDTOIN));

        when(taskListMapper.toDto(taskListService.newTaskList(user, taskList1))).thenReturn(taskListDTOOUT);
        mockMvc.perform(
                post("/todolist/tasklist")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(taskListDTOIN)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(taskListDTOOUT)));
    }
    @DisplayName("Test: Get All Task Lists")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testGetAllTaskLists() throws Exception {
        User user = new User("email@mail.com", "DumpPass1234");
        Long id = 13L;
        String todoListName1 = "TASK LIST TODO";
        String todoListName2 = "NEW TASK LIST NAME";
        TaskList taskList1 = new TaskList(todoListName1, user);
        TaskList taskList2 = new TaskList(todoListName2, user);

        taskList1.setTodoListID(id);
        taskList2.setTodoListID(id);

        System.out.println(objectMapper.writeValueAsString(taskList1));
        System.out.println(objectMapper.writeValueAsString(taskList2));

        List<TaskListDTO> taskLists = new ArrayList<>();

        TaskListDTO taskListDTO1 = new TaskListDTO();
        taskListDTO1.setTodoListName(taskList1.getTodoListName());

        taskLists.add(taskListDTO1);

        when(taskListMapper.toDtos(taskListService.getTaksListsbyUser(user))).thenReturn(taskLists);
        mockMvc.perform(
                get("/todolist/tasklist"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(taskLists)));
    }
    @DisplayName("Test: Update Task List")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testUpdateTaskList() throws Exception {
        UUID uuid = UUID.randomUUID();
        User user = new User("email@mail.com", "DumpPass1234");
        user.setUserID(uuid);
        Long id = 13L;
        String todoListName1 = "TASK LIST TODO";
        String todoListName2 = "NEW TASK LIST NAME";
        TaskList taskList1 = new TaskList(todoListName1, user);
        TaskList taskList2 = new TaskList(todoListName2, user);

        taskList1.setTodoListID(id);
        taskList2.setTodoListID(id);

        System.out.println(objectMapper.writeValueAsString(taskList1));
        System.out.println(objectMapper.writeValueAsString(taskList2));

        when(taskListService.updateTaskList(id, todoListName2)).thenReturn(taskList2);
        mockMvc.perform(
                patch("/todolist/tasklist/{id}", id.toString())
                        .queryParam("tklname", todoListName2))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(taskList2)));
    }
    @DisplayName("Test: Delete Task List")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testDeleteTaskList() throws Exception {
        UUID uuid = UUID.randomUUID();
        User user = new User("email@mail.com", "DumpPass1234");
        user.setUserID(uuid);
        Long id = 13L;
        String todoListName1 = "TASK LIST TODO";
        String todoListName2 = "NEW TASK LIST NAME";
        TaskList taskList1 = new TaskList(todoListName1, user);
        TaskList taskList2 = new TaskList(todoListName2, user);

        taskList1.setTodoListID(id);
        taskList2.setTodoListID(id);

        System.out.println(objectMapper.writeValueAsString(taskList1));
        System.out.println(objectMapper.writeValueAsString(taskList2));

        //when(taskListService.deleteTasksLists(id)).thenReturn();
        mockMvc.perform(
                delete("/todolist/tasklist/{id}", id.toString()))
                .andExpect(status().isOk());
    }
}