package com.bootcamp.project.controller.API;

import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.service.TaskListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public interface TaskListAPIController {
    String route = "tasklist";
    @GetMapping(value = route)
    List<TaskList> showTaskLists();
    @PostMapping(value = route + "/new")
    TaskList newTaskList(@RequestBody TaskList tasklist);
}
