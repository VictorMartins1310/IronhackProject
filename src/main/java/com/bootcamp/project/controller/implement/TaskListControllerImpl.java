package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.TaskListController;
import com.bootcamp.project.dto.TaskListDTO;
import com.bootcamp.project.mappers.TaskListMapper;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "todolist/tasklist")
public class TaskListControllerImpl implements TaskListController {
    private final TaskListService taskListService;
    private final UserService userService;

    private final TaskListMapper taskListMapper;

    /** Create an TaskList */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskListDTO newTaskList(@RequestBody TaskListDTO taskListDTO){
        User loggedUser = userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        TaskList taskList = taskListService.newTaskList(loggedUser, new TaskList(taskListDTO.getTodoListName(), loggedUser));
        return taskListMapper.toDto(taskList);
    }
    /** Show all TaskLists by that an User have */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskListDTO> showTaskLists(){
        User loggedUser = userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return taskListMapper.toDtos(taskListService.getTaksListsbyUser(loggedUser));
    }
    @PatchMapping(value = "/{idtasklist}")
    @ResponseStatus(HttpStatus.OK)
    public TaskList updateTaskList(@PathVariable("idtasklist") Long taskListID, @RequestParam(value = "tklname") String tklname){
        return taskListService.updateTaskList(taskListID, tklname);
    }
    @DeleteMapping(value = "/{idtasklist}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTaskList(@PathVariable("idtasklist") Long taskListID){

    }
}