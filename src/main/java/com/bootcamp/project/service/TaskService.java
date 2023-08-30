package com.bootcamp.project.service;

import com.bootcamp.project.model.Task;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.repos.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    // Repositories
    private final TaskRepository taskRepository;

    public Task newTask(Task task){ return taskRepository.save(task); }
    public void taskDone(Long id){
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent())
            taskRepository.delete(task.get());
    }
    public List<Task> getAllTasksOfTaskList(TaskList taskList){
        return taskList.getTasks();
    }
}