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
@RequestMapping(name = "todoList", value = "todolist")
public class TodoListControllerImpl implements TodoListController {
    private final ToDoListService toDoListService;
    @GetMapping(value = "/{userID}")
    public List<ToDoList> getAllTodoListByID(@PathVariable("userID") UUID id){
        return toDoListService.findAllByUser(id);
    }

// REMOVED from Interface, dont make sense create TodoList because creating Task or Shopping lists
    @PostMapping(value = "/{ userID}")
    public DTOToDoList newTodoList(@PathVariable("userID") UUID id, @RequestBody DTOToDoList todoListDTO){
        return toDoListService.newTodoList(id, todoList);
    }

}