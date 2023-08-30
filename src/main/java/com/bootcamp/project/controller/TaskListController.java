package com.bootcamp.project.controller;

import com.bootcamp.project.model.TaskList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public interface TaskListController {
    Object newTaskList(TaskList taskList);
    Object showTaskLists();
    Object updateTaskList(Long taskListID);
    void deleteTaskList(Long taskListID);
}