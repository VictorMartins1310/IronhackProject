package com.bootcamp.project.controller.rest;

import com.bootcamp.project.controller.api.TaskAPIController;
import com.bootcamp.project.model.Product;
import com.bootcamp.project.model.Task;
import com.bootcamp.project.model.TaskList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "rest")
public abstract class TaskRestController implements TaskAPIController {
    @PostMapping(value = rootTaskList + "/{"+ taskLID + "}/" + routeAdd +"/new")
    public TaskList addTask(@PathVariable(taskLID) Long taskLID, @RequestBody Task task){
        return null; //TODO
    }
    @GetMapping(value = rootTaskList + "/{" + taskLID + "}/" + routeAdd)
    public TaskList getAllTasksOfTaskList(@PathVariable(taskLID) Long id){
        return null; //TODO
    }
}
