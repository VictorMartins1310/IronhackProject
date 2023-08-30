package com.bootcamp.project.controller;

import com.bootcamp.project.model.TaskList;

public interface TaskListController {
    Object newTaskList(TaskList taskList);
    Object showTaskLists();
    Object updateTaskList(Long taskListID);
    void deleteTaskList(Long taskListID);
}