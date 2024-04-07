package com.bootcamp.project.controller.implement.web;

import com.bootcamp.project.controller.abstracts.TodoListController;
import com.bootcamp.project.dto.TaskListDTO;
import com.bootcamp.project.dto.TaskListTasksDTO;
import com.bootcamp.project.mappers.TodoListMapper;
import com.bootcamp.project.service.ShoppingListService;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.ToDoListService;
import com.bootcamp.project.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** This Controller is destined for the Task List
 * It can Create, Update and Delete a Task List
 */

@Controller
@RequestMapping(value = "web/todolist/tasklist")
public class TaskListControllerWevImpl extends TodoListController {

    private final TodoListMapper taskListMapper;

    public TaskListControllerWevImpl(ToDoListService toDoListService, TaskListService taskListService, ShoppingListService shoppingLService, UserService userService, TodoListMapper todoListMapper, TodoListMapper taskListMapper) {
        super(toDoListService, taskListService, shoppingLService, userService, todoListMapper);
        this.taskListMapper = taskListMapper;
    }


    /** Create an TaskList */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskListDTO addTaskList(@RequestBody TaskListDTO taskListDTO){
        return taskListMapper.toTaskListDTO(newList(taskListDTO));
    }
    /** Show all TaskLists by that a User have */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskListDTO> showLists(){
        return taskListMapper.toTaskListsDtos(showTaskLists());
    }
    @GetMapping(value = "/{idtasklist}")
    @ResponseStatus(HttpStatus.OK)
    public TaskListDTO showList(@PathVariable("idtasklist")Long id){
        return taskListMapper.toTaskListDTO(showTaskList(id));
    }
    @PatchMapping(value = "/{idtasklist}")
    @ResponseStatus(HttpStatus.OK)
    public TaskListTasksDTO update(@PathVariable("idtasklist") Long taskListID, @RequestParam(value = "tklname") String tklname){
        return taskListMapper.toTaskListTasksDTO(updateTaskList(taskListID, tklname));
    }

    @DeleteMapping(value = "/{idtasklist}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("idtasklist") Long taskListID){
        deleteTaskList(taskListID);
    }
}