package com.bootcamp.project.controller;

import com.bootcamp.project.model.Task;

public interface TaskController {
    String userID = "uuid";
    String routeAdd = "tasks";
    Object addTask(Long todoID, Task task);
    Object getAllTasksOfTaskList(Long id);
    void deleteTask(Long id);
    Object UpdateTask();
}