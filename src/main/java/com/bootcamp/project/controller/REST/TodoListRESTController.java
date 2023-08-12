package com.bootcamp.project.controller.REST;

import com.bootcamp.project.controller.API.TodoListAPIController;
import com.bootcamp.project.model.ToDoList;
import com.bootcamp.project.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping(name = "TodoListREST", value = "rest/todolist")
public class TodoListRESTController implements TodoListAPIController {
    final ToDoListService todoListService;
    @GetMapping
    public List<ToDoList> showTodoList() {
        return todoListService.findAll();
    }
    @PostMapping("new")
    public ToDoList newTodoList(){
        return null;
    }
}
