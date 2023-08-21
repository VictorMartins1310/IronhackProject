package com.bootcamp.project.controller.rest;

import com.bootcamp.project.controller.api.TaskAPIController;
import com.bootcamp.project.model.Task;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "rest")
public class TaskRestController implements TaskAPIController {
    private final TaskListService taskListService;
    @PostMapping(value = route + "/{"+ taskLID + "}/" + routeAdd +"/new")
    public TaskList addTask(@PathVariable(taskLID) Long taskID, @RequestBody Task task){
        return taskListService.addTask2List(taskID, task);
    }
    @GetMapping(value = route + "/{" + taskLID + "}/" + routeAdd)
    public List<Task> getAllTasksOfTaskList(@PathVariable(taskLID) Long taskID){
        return taskListService.getAllTasksOfTaskList(taskID);
    }
}
