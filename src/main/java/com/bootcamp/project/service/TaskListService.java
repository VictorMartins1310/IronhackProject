package com.bootcamp.project.service;

import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.repos.TaskListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskListService {
    private final TaskListRepository taskListRepository;

    public TaskList newTaskList(TaskList tasklist) {
        return taskListRepository.save(tasklist);
    }

    public List<TaskList> findAll() {
        return taskListRepository.findAll();
    }
}
