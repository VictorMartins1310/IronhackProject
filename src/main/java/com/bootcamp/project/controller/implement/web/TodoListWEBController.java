package com.bootcamp.project.controller.implement.web;

import com.bootcamp.project.controller.TodoListController;
import com.bootcamp.project.model.ToDoList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "todoList", value = "todolist")
public class TodoListWEBController implements TodoListController {
    @PostMapping(value = "/{id}/new")
    public ModelAndView newTodoList(@PathVariable("id") UUID id, @RequestBody ToDoList todoList){
        return null; // TODO Develop here
    }
    @GetMapping(value = "/{id}")
    public ModelAndView getAllTodoListByID(@PathVariable("id") UUID id){
        return null; // TODO develop here
    }
}