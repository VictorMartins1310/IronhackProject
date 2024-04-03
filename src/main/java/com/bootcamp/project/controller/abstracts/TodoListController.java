package com.bootcamp.project.controller.abstracts;


import com.bootcamp.project.dto.*;
import com.bootcamp.project.mappers.TodoListMapper;
import com.bootcamp.project.model.*;
import com.bootcamp.project.service.ShoppingListService;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.ToDoListService;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class TodoListController implements com.bootcamp.project.controller.interfaces.TodoListController {
    private final ToDoListService toDoListService;
    private final TaskListService taskListService;
    private final ShoppingListService shoppingLService;
    private final UserService userService;

    protected final TodoListMapper todoListMapper;

    public User getAutenticatedUser(){
        return userService.getAutenticatedUser();
    }

    /* TaskList Section */

    public TaskList newList(TaskListDTO taskListDTO){
        TaskList taskList = new TaskList(taskListDTO.getTodoListName(), getAutenticatedUser());
        return taskListService.newTaskList(getAutenticatedUser(), taskList);
    }

    public List<TaskList> showTaskLists(){
        return taskListService.getTaskListsByUser(getAutenticatedUser());
    }

    public TaskList showTaskList(Long id){
        return taskListService.getTaskListByID(id);
    }

    public TaskList updateTaskList(Long taskListID, String taskListName){
        return taskListService.updateTaskList(taskListID, taskListName);
    }

    public void deleteTaskList(Long taskListID){
        taskListService.deleteTasksList(taskListID);
    }


    /* Shopping List Section */

    public ShoppingList newList(ShoppingListDTO newShoppingData){
        return shoppingLService.newShoppingList(getAutenticatedUser(), newShoppingData.getMarketName());
    }

    public List<ShoppingList> showShoppingLists(){
        return shoppingLService.getShoppingLists(getAutenticatedUser());
    }
    public ShoppingList showShoppingList(Long id){
        return shoppingLService.getShoppingList(id);
    }
    public ShoppingList updateShoppingList(Long id, String todoListName, String marketName){
        return shoppingLService.updateShoppingList(id, todoListName, marketName);
    }
    public void deleteShoppingList(Long id){
        shoppingLService.deleteShoppingList(id);
    }

    public List<ToDoList> showTodoLists(){
        return toDoListService.findAllByUser(getAutenticatedUser().getUserID());
    }
}