package com.bootcamp.project.controller.implement.web;

import com.bootcamp.project.controller.abstracts.TodoListController;
import com.bootcamp.project.dto.ToDoListDTO;
import com.bootcamp.project.mappers.TodoListMapper;
import com.bootcamp.project.service.ShoppingListService;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.ToDoListService;
import com.bootcamp.project.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/** This controller only have one function: Show All Lists (Task Lists & Shopping Lists) */
@Controller
@RequestMapping(name = "todoList", value = "web/todolist")
public class TodoListControllerWebImpl extends TodoListController {
    public TodoListControllerWebImpl(ToDoListService toDoListService, TaskListService taskListService, ShoppingListService shoppingLService, UserService userService, TodoListMapper todoListMapper) {
        super(toDoListService, taskListService, shoppingLService, userService, todoListMapper);
    }

    /** Method that show all Lists that a User haves */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ToDoListDTO> getAllTodoList(){
        return todoListMapper.toDto(showTodoLists());
    }

}