package com.bootcamp.project.controller;

import com.bootcamp.project.model.TaskList;

import java.util.UUID;

public interface TaskListController {
    Object showTaskLists(UUID uuid);
    Object newTaskList(UUID uuid, TaskList taskList);
}