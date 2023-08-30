package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.TaskListController;
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

    /** Create an TaskList */
    @PostMapping(value = "/user/{userID}")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskList  newTaskList(@PathVariable("userID") UUID uuid, TaskList taskList){
        User user = userService.getUser(uuid);
        return tasklistService.newTaskList(user, new TaskList(taskList.getTodoListName(), user));
    }
    /** Show all TaskLists by that an User have */
    @GetMapping(value = "/user/{userID}")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskList> showTaskLists(@PathVariable("userID") UUID uuid){
        User user = userService.getUser(uuid);
        return tasklistService.getTaksListsbyUser(user);
    }
    @PatchMapping(value = "/{idtasklist}")
    @ResponseStatus(HttpStatus.OK)
    public TaskList updateTaskList(@PathVariable("idtasklist") Long taskListID){
        return null; // TODO
    }
    @DeleteMapping(value = "/{idtasklist}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTaskList(@PathVariable("idtasklist") Long taskListID){
    }
}