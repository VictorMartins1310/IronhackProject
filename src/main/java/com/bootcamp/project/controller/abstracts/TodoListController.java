package com.bootcamp.project.controller.abstracts;


import com.bootcamp.project.mappers.TodoListMapper;
import com.bootcamp.project.service.ToDoListService;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class TodoListController implements com.bootcamp.project.controller.TodoListController {
    protected final ToDoListService toDoListService;
    protected final TodoListMapper todoListMapper;
    protected final UserService userService;
}