package com.bootcamp.project.service;

import com.bootcamp.project.exception.ProjectException;
import com.bootcamp.project.model.*;
import com.bootcamp.project.repos.TaskListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskListService {
    private final TaskListRepository taskListRepository;
    private final TaskService taskService;
    private final UserService userService;

    public TaskList getTaskList(Long id){
        return taskListRepository.getReferenceById(id);
    }
    public TaskList newTaskList(UUID userID, TaskList taskList){
        User user = userService.getUser(userID);
        return taskListRepository.save(new TaskList(taskList.getTodoListName(), user));
    }
    public List<TaskList> getAllbyUser(UUID userID){
        User user = userService.findUserDetailsByUserID(userID);
        return taskListRepository.findTaskListsByUser(user);
    }
    public List<Task> getAllTasksOfTaskList(Long taskID){
        TaskList taskList = taskListRepository.findById(taskID).get();
        return taskList.getTasks();
    }
    public TaskList addTask2List(Long taskID, Task task){
        TaskList taskList;
        if (taskListRepository.findById(taskID).isPresent()){
            taskList = taskListRepository.findById(taskID).get();
            Task savedTask = taskService.newTask(task);
            taskList.addTask(savedTask);
            return taskListRepository.save(taskList);
        } else
            throw new ProjectException("Cannot find Task list");
    }
}