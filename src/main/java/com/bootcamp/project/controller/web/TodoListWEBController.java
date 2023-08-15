package com.bootcamp.project.controller.web;

import com.bootcamp.project.controller.api.TodoListAPIController;
import com.bootcamp.project.model.ToDoList;
import com.bootcamp.project.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "todoListWEB", value = "web")
public class TodoListWEBController implements TodoListAPIController {
    final ToDoListService todoListService;
    private final Map<String, Object> map = new HashMap<>();
    @GetMapping(value = route)
    public ModelAndView showTodoList(){
        map.put("todolist", "todolist");
        map.put("Stupid","thing");
        return new ModelAndView("index",map);
    }
    @GetMapping(value = route + "/new" )
    public ModelAndView newTodoList(ToDoList td){
        map.put("todolist", "todolist");
        return new ModelAndView("index.html",map);
    }
    @PostMapping(value = route + "/new" )
    public ModelAndView newTodoList(){
        map.put("todolist", "todolist");
        return new ModelAndView("index",map);
    }
    @GetMapping(value = "test")
    public String test(){
        return "Hello im on WEB Mode";
    }
}
