package com.bootcamp.project.service;

import com.bootcamp.project.model.Task;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.repos.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task newTask(Task task){
        return taskRepository.save(task);
    }
}
