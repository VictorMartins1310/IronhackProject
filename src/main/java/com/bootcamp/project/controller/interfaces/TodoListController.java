package com.bootcamp.project.controller.interfaces;


import com.bootcamp.project.dto.ShoppingListDTO;
import com.bootcamp.project.dto.TaskListDTO;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.model.ToDoList;

import java.util.List;

public interface TodoListController {
    ShoppingList newList(ShoppingListDTO listDTO);
    TaskList newList(TaskListDTO listDTO);
    List<ShoppingList> showShoppingLists();
    List<TaskList> showTaskLists();
    List<ToDoList> showTodoLists();
    ShoppingList showShoppingList(Long id);
    TaskList showTaskList(Long id);
    TaskList updateTaskList(Long taskListID, String tklname);
    ShoppingList updateShoppingList(Long id,String todolistname, String marketName);
    void deleteShoppingList(Long id);
    void deleteTaskList(Long taskListID);

}