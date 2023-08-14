package com.bootcamp.project.controller.REST;

import com.bootcamp.project.controller.API.TaskAPIController;
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
    List<TaskList> showTaskLists(){
        return tasklistService.findAll();
    }
    @PostMapping(value = route + "/new")
    TaskList newTaskList(@RequestBody TaskList tasklist){
        return tasklistService.newTaskList(tasklist);
    }
}
