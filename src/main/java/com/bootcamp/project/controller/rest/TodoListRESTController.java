package com.bootcamp.project.controller.rest;

import com.bootcamp.project.controller.api.TodoListAPIController;
import com.bootcamp.project.model.ToDoList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping(name = "todoListREST", value = "rest")
public class TodoListRESTController implements TodoListAPIController {
    @GetMapping(value = "test")
    public String test(){ return "Hello im on REST Mode"; }
}
