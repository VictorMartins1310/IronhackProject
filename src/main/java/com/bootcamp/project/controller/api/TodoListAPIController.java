package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.ToDoList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(name = "todoListAPI", value = "api")
public interface TodoListAPIController {
    String route = "todolist";
    @GetMapping(value = "test")
    String test();
    @GetMapping(value = route + "/{id}")
    Object getAllTodoListByID(@PathVariable("id") UUID id);
    @PostMapping(value = route + "/{id}/new")
    Object newTodoList(@PathVariable("id") UUID id, @RequestBody ToDoList todoList);
}