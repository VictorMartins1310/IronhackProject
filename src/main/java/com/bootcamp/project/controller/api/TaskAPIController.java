package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.Task;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api")
public interface TaskAPIController{
    String rootTodo = "todolist";
    String route = rootTodo + "/tasklist";
    String userID = "uuid";
    String taskLID = "tasklid";
    String routeAdd = "tasks";
    @PostMapping(value = route + "/{"+ taskLID + "}/" + routeAdd +"/new")
    Object addTask(@PathVariable(taskLID) Long todoID, @RequestBody Task task);
    @GetMapping(value = route + "/{" + taskLID + "}/" + routeAdd)
    Object getAllTasksOfTaskList(@PathVariable(taskLID) Long id);
}