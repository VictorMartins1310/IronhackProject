package com.bootcamp.project.controller;

import com.bootcamp.project.dto.TaskListDTO;
import com.bootcamp.project.dto.ToDoListDTO;
import com.bootcamp.project.model.TaskList;
import org.springframework.web.bind.annotation.RequestParam;

public interface TaskListController {
    Object newTaskList(TaskListDTO taskListDTO);
    Object showTaskLists();
    Object updateTaskList(Long taskListID, String tklname);
    Boolean deleteTaskList(Long taskListID);
}