package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.TaskListController;
import com.bootcamp.project.model.Task;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "todolist/tasklist")
public class TaskListControllerImpl implements TaskListController {
    private final TaskListService tasklistService;
    private final UserService userService;

    /** Show all TaskLists by that an User have */
    @GetMapping(value = "/user/{userID}")
    public List<TaskList> showTaskLists(@PathVariable("userID") UUID uuid){
        return tasklistService.getAllbyUser(uuid);
    }
    @PostMapping(value = "/user/{userID}")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskList  newTaskList(@PathVariable("userID") UUID uuid, TaskList taskList){
        User user = userService.getUser(uuid);
        return tasklistService.newTaskList(uuid, new TaskList(taskList.getTodoListName(), user));
    }
}