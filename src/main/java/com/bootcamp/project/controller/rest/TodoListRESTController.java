package com.bootcamp.project.controller.rest;

import com.bootcamp.project.controller.api.TodoListAPIController;
import com.bootcamp.project.model.ToDoList;
import com.bootcamp.project.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController //Used for processing JSON with @Responsebody
@RequiredArgsConstructor
@RequestMapping(name = "todoListREST", value = "rest")
public class TodoListRESTController implements TodoListAPIController {
    final ToDoListService todoListService;
    @GetMapping(value = route)
    public List<ToDoList> showTodoList() {
        return todoListService.findAll();
    }
    @PostMapping(value = route + "/new")
    public ToDoList newTodoList(@RequestBody ToDoList toDoList){
        return todoListService.newToDoList(toDoList);
    }
    @GetMapping(value = "test")
    public String test(){
        return "Hello im on REST Mode";
    }
}
