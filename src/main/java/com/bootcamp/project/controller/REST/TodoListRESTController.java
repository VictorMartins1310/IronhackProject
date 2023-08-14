package com.bootcamp.project.controller.REST;

import com.bootcamp.project.controller.API.TodoListAPIController;
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
    @GetMapping(route)
    public List<ToDoList> showTodoList() {
        return todoListService.findAll();
    }
    @PostMapping(route + "/new")
    public ToDoList newTodoList(@RequestBody ToDoList toDoList){
        return todoListService.newToDoList(toDoList);
    }
    @GetMapping("test")
    public String test(){
        return "Hello im on REST Mode";
    }
}
