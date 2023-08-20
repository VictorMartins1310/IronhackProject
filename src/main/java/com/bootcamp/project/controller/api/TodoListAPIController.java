package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.ToDoList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(name = "todoListAPI", value = "api")
public interface TodoListAPIController {
    String rootTodo = "todolist";
    String userID = "uuid";
    @GetMapping(value = rootTodo + "/{" + userID + "}")
    Object getAllTodoListByID(@PathVariable(userID) UUID id);
    @PostMapping(value = rootTodo + "/{" + userID + "}/new")
    Object newTodoList(@PathVariable(value = userID) UUID id, @RequestBody ToDoList todoList);
}