package com.bootcamp.project.controller.implement.rest;

import com.bootcamp.project.controller.abstracts.TodoListController;
import com.bootcamp.project.dto.ToDoListDTO;
import com.bootcamp.project.mappers.TodoListMapper;
import com.bootcamp.project.service.ShoppingListService;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.ToDoListService;
import com.bootcamp.project.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** This controller only have one function: Show All Lists (Task Lists & Shopping Lists) */
@RestController
@RequestMapping(name = "todoList", value = "todolist")
public class TodoListControllerImpl extends TodoListController {
    public TodoListControllerImpl(ToDoListService toDoListService, TaskListService taskListService, ShoppingListService shoppingLService, UserService userService, TodoListMapper todoListMapper) {
        super(toDoListService, taskListService, shoppingLService, userService, todoListMapper);
    }

    /** Method that show all Lists that a User haves */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ToDoListDTO> getAllTodoList(){
        return todoListMapper.toDto(showTodoLists());
    }

}