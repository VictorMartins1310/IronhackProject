package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.TodoListController;
import com.bootcamp.project.model.ToDoList;
import com.bootcamp.project.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "todoList", value = "todolist")
public class TodoListControllerImpl implements TodoListController {
    private final ToDoListService toDoListService;
    @GetMapping(value = "/{"+ userID + "}")
    public List<ToDoList> getAllTodoListByID(@PathVariable(userID) UUID id){
        return toDoListService.findAllByUser(id);
    }
    @PostMapping(value = "/{" + userID + "}")
    public ToDoList newTodoList(@PathVariable(userID) UUID id, @RequestBody ToDoList todoList){
        return toDoListService.newTodoList(id, todoList);
    }
}