package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.TaskController;
import com.bootcamp.project.dto.TaskDTO;
import com.bootcamp.project.mappers.TaskListMapper;
import com.bootcamp.project.mappers.TaskMapper;
import com.bootcamp.project.model.Task;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "tasklist", value = "todolist/tasklist/{taskLID}")
public class TaskControllerImpl implements TaskController {
    private final TaskListService taskListService;
    private final TaskService taskService;
    private final TaskMapper taskMapper;
    private final TaskListMapper taskListMapper;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<TaskDTO> addTask(@PathVariable("taskLID") Long taskID, @RequestBody TaskDTO taskDTO){
        Task task = taskMapper.toEntity(taskDTO);
        TaskList taskList = taskListService.addTask2List(taskID, task);
        return taskMapper.toDto(taskService.getAllTasksOfTaskList(taskList));
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasksOfTaskList(@PathVariable("taskLID") Long taskID){
        TaskList taskL = taskListService.getTaskListByID(taskID);
        return taskService.getAllTasksOfTaskList(taskL);
    }
    @Override
    @PatchMapping(value = "/{taskID}/done")
    public void taskDone(@PathVariable("taskID") Long idTask) {
        taskService.taskDone(idTask);
    }
    @PatchMapping(value ="/{taskID}")
    public void updateTask(@PathVariable("taskID") Long idTask, @RequestParam("tname") String taskName){
        taskService.updateTaskName(idTask, taskName);
    }
}