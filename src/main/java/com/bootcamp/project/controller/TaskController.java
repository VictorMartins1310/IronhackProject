package com.bootcamp.project.controller;

import com.bootcamp.project.model.Task;
import org.springframework.web.bind.annotation.*;

public interface TaskController {
    String userID = "uuid";
    String taskLID = "tasklid";
    String routeAdd = "tasks";
    @PostMapping(value =  "/{"+ taskLID + "}/" + routeAdd +"/new")
    Object addTask(@PathVariable(taskLID) Long todoID, @RequestBody Task task);
    @GetMapping(value = "/{" + taskLID + "}/" + routeAdd)
    Object getAllTasksOfTaskList(@PathVariable(taskLID) Long id);
}