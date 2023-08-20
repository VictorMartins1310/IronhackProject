package com.bootcamp.project.controller.web;

import com.bootcamp.project.controller.api.TodoListAPIController;
import com.bootcamp.project.model.ToDoList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "todoListWEB", value = "web")
public class TodoListWEBController implements TodoListAPIController {
    @PostMapping(value = rootTodo + "/{id}/new")
    public ModelAndView newTodoList(@PathVariable("id") UUID id, @RequestBody ToDoList todoList){
        return null; // TODO Develop here
    }
    @GetMapping(value = rootTodo + "/{id}")
    public ModelAndView getAllTodoListByID(@PathVariable("id") UUID id){
        return null; // TODO develop here
    }
}