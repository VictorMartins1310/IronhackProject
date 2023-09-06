package com.bootcamp.project.controllerTest;

import com.bootcamp.project.controller.implement.TaskControllerImpl;
import com.bootcamp.project.dto.TaskDTO;
import com.bootcamp.project.mappers.TaskMapper;
import com.bootcamp.project.mappers.TodoListMapper;
import com.bootcamp.project.model.Task;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.TaskService;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(TaskControllerImpl.class)
public class TaskControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private WebApplicationContext webApplicationContext;

    @MockBean private TaskListService taskListService;
    @MockBean private TaskService taskService;
    @MockBean private TaskMapper taskMapper;
    @MockBean private TodoListMapper taskListMapper;

    private final Task task1 = new Task();

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @DisplayName("Test: Create a Task")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testCreateTask() throws Exception {
        String taskStr = "Task1";
        Long id = 13L;
        TaskList taskList = new TaskList();
        taskList.setTodoListID(id);

        task1.setTask(taskStr);
        task1.setTaskID(id);
        TaskDTO taskDTO1 = new TaskDTO();
        taskDTO1.setTask(taskStr);
        TaskDTO taskDTO2 = new TaskDTO();
        taskDTO2.setTask(taskStr);
        taskDTO2.setDone(false);

        List<TaskDTO> taskDTOList = new ArrayList<>();
        taskDTOList.add(taskDTO2);

        when((taskMapper.toDto(taskService.getAllTasksOfTaskList(taskList)))).thenReturn(taskDTOList);
        mockMvc.perform(post("/todolist/tasklist/{id}", id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(taskDTO1)))
            .andExpect(status().isCreated())
            .andExpect(content().json(objectMapper.writeValueAsString(taskDTOList)));
    }

    @DisplayName("Test: Update a Task")
    @WithMockUser(username = "testUser", roles = "USER")
    @Test public void testUpdateTask() throws Exception {
        String
                taskIn = "Task1",
                taskOut = "Task2";
        Long
                taskID = 13L,
                taskListID = 13L;

        TaskList taskList = new TaskList();
        taskList.setTodoListID(taskListID);

        task1.setTask(taskIn);
        task1.setTaskID(taskID);

        taskList.addTask(task1);

        TaskDTO taskDtoIn = new TaskDTO();
        taskDtoIn.setTask(taskIn);
        TaskDTO taskDtoOut = new TaskDTO();
        taskDtoOut.setTask(taskOut);
        taskDtoOut.setDone(false);

        when((taskMapper.toDto(taskService.updateTaskName(taskID, taskIn)))).thenReturn(taskDtoOut);

        mockMvc.perform(
                patch("/todolist/tasklist/{tasklistID}/task/{taskID}", taskListID, taskID.toString())
                        .queryParam("tname", taskOut))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(taskDtoOut)));
    }
}
