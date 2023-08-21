package com.bootcamp.project.controller.rest;

import com.bootcamp.project.controller.api.TaskListAPIController;
import com.bootcamp.project.model.Task;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "rest")
public class TaskListRESTController implements TaskListAPIController {
    private final TaskListService tasklistService;

    @GetMapping(value = route + "/user/{" + userID + "}")
    public List<TaskList> showTaskLists(@PathVariable(userID) UUID uuid){
        return tasklistService.getAllbyUser(uuid);
    }
    @PostMapping(value = route + "/user/{" + userID + "}/new")
    public TaskList  newTaskList(@PathVariable(userID) UUID uuid){
        return tasklistService.newTaskList(uuid, new TaskList()); // TODO Change part TaskList()
    }
    @GetMapping(value = route + "/{" + taskLID + "}")
    public List<Task> tasksByID(@PathVariable(taskLID) Long id) { return tasklistService.getAllTasksOfTaskList(id); }
}