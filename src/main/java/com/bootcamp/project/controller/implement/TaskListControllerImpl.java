package com.bootcamp.project.controller.implement;

import com.bootcamp.project.dto.TaskListDTO;
import com.bootcamp.project.dto.TaskListTasksDTO;
import com.bootcamp.project.mappers.TodoListMapper;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** This Controller is destined for the Task List
 * It can Create, Update and Delete a Task List
 */
@RestController
@RequestMapping(value = "todolist/tasklist")
public class TaskListControllerImpl extends com.bootcamp.project.controller.abstracts.TaskListController {
    public TaskListControllerImpl(TaskListService taskListService, TodoListMapper taskListMapper, UserService userService) {
        super(taskListService, taskListMapper, userService);
    }

    /** Create an TaskList */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskListDTO newTaskList(@RequestBody TaskListDTO taskListDTO){
        return taskListMapper.toTaskListDTO(super.addTaskList(taskListDTO));
    }
    /** Show all TaskLists by that a User have */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskListDTO> showTaskLists(){
        return taskListMapper.toTaskListsDtos(taskListService.getTaskListsByUser(userService.getAutenticatedUser()));
    }

    @PatchMapping(value = "/{idtasklist}")
    @ResponseStatus(HttpStatus.OK)
    public TaskListTasksDTO updateTaskList(@PathVariable("idtasklist") Long taskListID, @RequestParam(value = "tklname") String tklname){
        return taskListMapper.toTaskListTasksDTO(taskListService.updateTaskList(taskListID, tklname));
    }

    @DeleteMapping(value = "/{idtasklist}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTaskList(@PathVariable("idtasklist") Long taskListID){
        taskListService.deleteTasksList(taskListID);
    }
}