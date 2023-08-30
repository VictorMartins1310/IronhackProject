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
    // Repositories
    private final TaskListRepository taskListRepository;
    // Services
    private final TaskService taskService;

    public TaskList newTaskList(User user, TaskList taskList){
        return taskListRepository.save(new TaskList(taskList.getTodoListName(), user));
    }
    public List<TaskList> getTaksListsbyUser(User user){
        return taskListRepository.findTaskListsByUserAndActiveIsTrue(user);
    }
    public TaskList getTaskListByID(Long id){
        return taskListRepository.findTaskListByTodoListID(id);
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
    /** Function that deletes a TaskList by ID */
    public void deleteTasksLists(User user){
        List<TaskList> taskLists = taskListRepository.findTaskListsByUser(user);
        if (!taskLists.isEmpty())
            taskListRepository.deleteAll(taskLists);
/*        if (!taskLists.isEmpty())
            for(TaskList tk : taskLists)
                taskListRepository.delete(tk);
*/
    }
}