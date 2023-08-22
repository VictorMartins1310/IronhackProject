package com.bootcamp.project.controller;

import com.bootcamp.project.model.TaskList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "todolist/tasklist")
public interface TaskListController {
    String userID = "uuid";
    String taskLID = "tasklid";
    @GetMapping(value = "/user/{" + userID + "}")
    Object showTaskLists(@PathVariable(userID) UUID uuid);
    @PostMapping(value = "/user/{" + userID + "}/new")
    Object newTaskList(@PathVariable(userID) UUID uuid, TaskList taskList);
    @GetMapping(value = "/{" + taskLID + "}")
    Object tasksByID(@PathVariable(taskLID) Long id);
}
