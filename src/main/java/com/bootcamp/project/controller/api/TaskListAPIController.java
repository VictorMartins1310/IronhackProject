package com.bootcamp.project.controller.api;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "api")
public interface TaskListAPIController extends TodoListAPIController {
    String rootTaskList = rootTodo + "/tasklist";
    String taskLID = "tasklid";
    @GetMapping(value = rootTaskList + "/user/{" + userID + "}")
    Object showTaskLists(@PathVariable(userID) UUID uuid);
    @PostMapping(value = rootTaskList + "/user/{" + userID + "}/new")
    Object newTaskList(@PathVariable(userID) UUID uuid);
    @GetMapping(value = rootTaskList + "/{" + taskLID + "}")
    Object tasksByID(@PathVariable(taskLID) Long id);
}
