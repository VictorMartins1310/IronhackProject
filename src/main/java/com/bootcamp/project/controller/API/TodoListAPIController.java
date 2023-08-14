package com.bootcamp.project.controller.API;

import com.bootcamp.project.model.ToDoList;
import org.springframework.web.bind.annotation.*;

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
    Object newTodoList(@RequestBody ToDoList todoList);
    @GetMapping("test")
    String test();
}