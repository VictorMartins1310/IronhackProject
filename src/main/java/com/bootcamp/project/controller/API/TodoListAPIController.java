package com.bootcamp.project.controller.API;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "todoListAPI", value = "api")
public interface TodoListAPIController {
    String route = "todolist";
    /***
     Shows all TodoLists
     */
    @GetMapping(route)
    Object showTodoList();
    /***
     * Insert new TodoList
     */
    @PostMapping(route + "/new")
    Object newTodoList();
    @GetMapping("test")
    String test();
}