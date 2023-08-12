package com.bootcamp.project.controller.WEB;

import com.bootcamp.project.controller.API.TodoListAPIController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(name = "TodoListWEB", value = "web/todolist")
public class TodoListWEBController implements TodoListAPIController {
    @GetMapping
    public ModelAndView showTodoList(){
        return new ModelAndView();
    }
    @PostMapping("new")
    public ModelAndView newTodoList(){
        return new ModelAndView();
    }
}
