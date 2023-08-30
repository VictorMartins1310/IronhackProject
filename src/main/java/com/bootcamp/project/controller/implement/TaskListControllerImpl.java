package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.TaskListController;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "todolist/tasklist")
public class TaskListControllerImpl implements TaskListController {
    private final TaskListService tasklistService;
    private final UserService userService;

    /** Create an TaskList */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskList  newTaskList(TaskList taskList){
        User loggedUser = userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return tasklistService.newTaskList(loggedUser, new TaskList(taskList.getTodoListName(), loggedUser));
    }
    /** Show all TaskLists by that an User have */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskList> showTaskLists(){
        User loggedUser = userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return tasklistService.getTaksListsbyUser(loggedUser);
    }
    @PatchMapping(value = "/{idtasklist}")
    @ResponseStatus(HttpStatus.OK)
    public TaskList updateTaskList(@PathVariable("idtasklist") Long taskListID){
        User loggedUser = userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return null; // TODO
    }
    @DeleteMapping(value = "/{idtasklist}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTaskList(@PathVariable("idtasklist") Long taskListID){

    }
}