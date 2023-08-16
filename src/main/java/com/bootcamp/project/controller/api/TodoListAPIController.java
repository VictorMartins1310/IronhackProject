package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.ToDoList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "todoListAPI", value = "api")
public interface TodoListAPIController {
    String route = "todolist";
    @GetMapping(value = "test")
    String test();
}