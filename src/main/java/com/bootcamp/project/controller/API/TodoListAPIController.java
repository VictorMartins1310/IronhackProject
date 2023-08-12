package com.bootcamp.project.controller.API;

public interface TodoListAPIController {
    /***
     Shows all TodoLists
     */
    Object showTodoList();

    /***
     * Insert new TodoList
     */
    Object newTodoList();
}