package com.bootcamp.project.controller;

import com.bootcamp.project.model.Task;

public interface TaskController {
    Object addTask(Long todoID, Task task);
    Object getAllTasksOfTaskList(Long id);
    void taskDone(Long id);
}