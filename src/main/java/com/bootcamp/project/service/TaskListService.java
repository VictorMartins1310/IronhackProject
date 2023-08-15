package com.bootcamp.project.service;

import com.bootcamp.project.model.Task;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.repos.TaskListRepository;
import com.bootcamp.project.repos.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskListService {
    private final TaskListRepository taskListRepository;
    private final TaskRepository taskRepository;

    public TaskList newTaskList(TaskList tasklist) {
        return taskListRepository.save(tasklist);
    }

    public List<TaskList> findAll() {
        return taskListRepository.findAll();
    }

    public TaskList addTask(Long todoID, Task task){
        return null;
    }
}
