package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api")
public interface TaskAPIController extends TaskListAPIController{
    String routeAdd = "tasks";
    @PostMapping(value = rootTaskList + "/{"+ taskLID + "}/" + routeAdd +"/new")
    Object addTask(@PathVariable(taskLID) Long todoID, @RequestBody Product product);
    @GetMapping(value = rootTaskList + "/{" + taskLID + "}/" + routeAdd)
    Object getAllTasksOfTaskList(@PathVariable(taskLID) Long id);
}