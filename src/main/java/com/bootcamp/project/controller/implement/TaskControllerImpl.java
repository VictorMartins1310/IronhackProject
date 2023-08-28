package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.TaskController;
import com.bootcamp.project.model.Task;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "tasklist", value = "todolist/tasklist")
public class TaskControllerImpl implements TaskController {
    private final TaskListService taskListService;
    @PostMapping(value = "/{taskLID}/" + routeAdd)
    @ResponseStatus(HttpStatus.CREATED)
    public TaskList addTask(@PathVariable("taskLID") Long taskID, @RequestBody Task task){
        return taskListService.addTask2List(taskID, task);
    }
    @GetMapping(value = "/{taskLID}/" + routeAdd)
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasksOfTaskList(@PathVariable("taskLID") Long taskID){
        return taskListService.getAllTasksOfTaskList(taskID);
    }

    @Override
    public void deleteTask(Long id) {
        // TODO
    }

    @Override
    public Task UpdateTask() {
        return null; // TODO
    }
}