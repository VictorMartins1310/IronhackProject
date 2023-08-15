package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.ToDoList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "todoListAPI", value = "api")
public interface TodoListAPIController {
    String route = "todolist";
    /***
     Shows all TodoLists
     */
    @GetMapping(value = route)
    Object showTodoList();
    /***
     * Insert new TodoList
     */
    @PostMapping(value = route + "/new")
    Object newTodoList(@RequestBody ToDoList todoList);
    @GetMapping(value = "test")
    String test();
}