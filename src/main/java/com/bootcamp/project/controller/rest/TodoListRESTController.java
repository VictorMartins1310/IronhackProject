package com.bootcamp.project.controller.rest;

import com.bootcamp.project.controller.api.TodoListAPIController;
import com.bootcamp.project.model.ToDoList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.ToDoListService;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "todoListREST", value = "rest")
public class TodoListRESTController implements TodoListAPIController {
    private final ToDoListService toDoListService;
    @GetMapping(value = "test")
    public String test(){ return "Hello im on REST Mode"; }
    @PostMapping(value = route + "/{id}/new")
    public ToDoList newTodoList(@PathVariable("id") UUID id, @RequestBody ToDoList todoList){
        return toDoListService.newTodoList(id, todoList);
    }
    @GetMapping(value = route + "/{id}")
    public List<ToDoList> getAllTodoListByID(@PathVariable("id") UUID id){
        return toDoListService.findByUserId(id);
    }
}