package com.bootcamp.project.controller;

import com.bootcamp.project.model.ToDoList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface TodoListController {
    String userID = "uuid";
    @GetMapping(value = "/{" + userID + "}")
    Object getAllTodoListByID(@PathVariable(userID) UUID id);
    @PostMapping(value = "/{" + userID + "}")
    Object newTodoList(@PathVariable(value = userID) UUID id, @RequestBody ToDoList todoList);
}