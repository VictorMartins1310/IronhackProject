package com.bootcamp.project.controller.abstracts;

import com.bootcamp.project.mappers.TaskMapper;
import com.bootcamp.project.mappers.TodoListMapper;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.TaskService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class TaskController implements com.bootcamp.project.controller.TaskController {
    protected final TaskListService taskListService;
    protected final TaskService taskService;
    protected final TaskMapper taskMapper;
    protected final TodoListMapper taskListMapper;
}