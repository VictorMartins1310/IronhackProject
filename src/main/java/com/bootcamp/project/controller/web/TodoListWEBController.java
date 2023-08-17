package com.bootcamp.project.controller.web;

import com.bootcamp.project.controller.api.TodoListAPIController;
import com.bootcamp.project.model.ToDoList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "todoListWEB", value = "web")
public class TodoListWEBController implements TodoListAPIController {
    @GetMapping(value = "test")
    public String test(){ return "Hello im on WEB Mode"; }
    @PostMapping(value = route + "/{id}/new")
    public ModelAndView newTodoList(@PathVariable("id") UUID id, @RequestBody ToDoList todoList){
        return null; // TODO Develop here
    }
}