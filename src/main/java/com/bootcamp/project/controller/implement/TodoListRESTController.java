package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.TodoListController;
import com.bootcamp.project.model.ToDoList;
import com.bootcamp.project.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "todoListREST", value = "rest")
public class TodoListRESTController implements TodoListController {
    private final ToDoListService toDoListService;
    @GetMapping(value = rootTodo + "/{"+ userID + "}")
    public List<ToDoList> getAllTodoListByID(@PathVariable(userID) UUID id){
        return toDoListService.findAllByUser(id);
    }
    @PostMapping(value = rootTodo + "/{" + userID + "}/new")
    public ToDoList newTodoList(@PathVariable(userID) UUID id, @RequestBody ToDoList todoList){
        return toDoListService.newTodoList(id, todoList);
    }
}