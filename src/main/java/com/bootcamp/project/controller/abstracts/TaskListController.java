package com.bootcamp.project.controller.abstracts;


import com.bootcamp.project.dto.TaskListDTO;
import com.bootcamp.project.dto.TaskListTasksDTO;
import com.bootcamp.project.mappers.TodoListMapper;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public abstract class TaskListController implements com.bootcamp.project.controller.TaskListController {
    protected final TaskListService taskListService;
    protected final TodoListMapper taskListMapper;
    protected final UserService userService;

    private User autenticatedUser;

    public TaskList addTaskList(TaskListDTO taskListDTO){
        autenticatedUser = userService.getAutenticatedUser();
        TaskList taskList = new TaskList(taskListDTO.getTodoListName(), autenticatedUser);
        return taskListService.newTaskList(autenticatedUser, taskList);
    }
    public List<TaskListDTO> showTaskLists(){
        autenticatedUser = userService.getAutenticatedUser();
        return taskListMapper.toTaskListsDtos(taskListService.getTaskListsByUser(autenticatedUser));
    }
    public TaskListTasksDTO updateTaskList(@PathVariable("idtasklist") Long taskListID, @RequestParam(value = "tklname") String tklname){
        return taskListMapper.toTaskListTasksDTO(taskListService.updateTaskList(taskListID, tklname));
    }
    public void deleteTaskList(@PathVariable("idtasklist") Long taskListID){
        taskListService.deleteTasksList(taskListID);
    }




}