package com.bootcamp.project.controller.rest;

import com.bootcamp.project.controller.api.TaskAPIController;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "rest")
public class TaskListRESTController implements TaskAPIController {
    private final TaskListService tasklistService;
    @GetMapping(value = route)
    public List<TaskList> showTaskLists(){ return tasklistService.findAll(); }
    @PostMapping(value = route + "/new")
    public TaskList newTaskList(@RequestBody TaskList tasklist){ return tasklistService.newTaskList(tasklist); }
    @GetMapping(value = route + "/{id}")
    public TaskList tasksByID(@PathVariable(name = "id") Long id){ return null; }
}