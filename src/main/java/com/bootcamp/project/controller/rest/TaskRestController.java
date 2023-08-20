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
public abstract class TaskRestController implements TaskAPIController {
    private final TaskListService taskListService;
    @PostMapping(value = rootTaskList + "/{"+ taskLID + "}/" + routeAdd +"/new")
    public TaskList addTask(@PathVariable(taskLID) Long taskLID, @RequestBody Task task){
        return taskListService.addTask2List(taskLID, task);
    }
    @GetMapping(value = rootTaskList + "/{" + taskLID + "}/" + routeAdd)
    public List<Task> getAllTasksOfTaskList(@PathVariable(taskLID) Long id){
        return taskListService.getAllTasksOfTaskList(id);
    }
}
