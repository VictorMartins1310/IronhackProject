package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.TaskList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api")
public interface TaskListAPIController {
    String route = "tasklist";
    @GetMapping(value = route)
    Object showTaskLists();
    @PostMapping(value = route + "/new")
    Object newTaskList(@RequestBody TaskList tasklist);
    @GetMapping(value = route + "/{id}")
    Object tasksByID(@PathVariable(name = "id") Long id);
}
