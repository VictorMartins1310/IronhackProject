package com.bootcamp.project.controller;

import com.bootcamp.project.dto.TaskDTO;
import com.bootcamp.project.model.Task;
import org.springframework.web.bind.annotation.PathVariable;

public interface TaskController {
    Object addTask(Long todoID, TaskDTO taskDTO);
    Object getAllTasksOfTaskList(Long id);
    void taskDone(Long id);
    void updateTask(Long idTask, String taskName);
}