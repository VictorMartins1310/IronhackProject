package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.TaskList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "api")
public interface TaskListAPIController {
    String rootTodo = "todolist";
    String route = rootTodo + "/tasklist";
    String userID = "uuid";
    String taskLID = "tasklid";
    @GetMapping(value = route + "/user/{" + userID + "}")
    Object showTaskLists(@PathVariable(userID) UUID uuid);
    @PostMapping(value = route + "/user/{" + userID + "}/new")
    Object newTaskList(@PathVariable(userID) UUID uuid, TaskList taskList);
    @GetMapping(value = route + "/{" + taskLID + "}")
    Object tasksByID(@PathVariable(taskLID) Long id);
}
