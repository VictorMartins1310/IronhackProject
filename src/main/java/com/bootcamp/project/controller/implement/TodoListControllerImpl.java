package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.TodoListController;
import com.bootcamp.project.model.ToDoList;
import com.bootcamp.project.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "todoList", value = "todolist")
public class TodoListControllerImpl implements TodoListController {
    // On this Controller is not so much to do
    private final ToDoListService toDoListService;
    /** Method that show all Lists that an User haves */
    @GetMapping(value = "/{userID}")
    @ResponseStatus(HttpStatus.OK)
    public List<ToDoList> getAllTodoListByID(@PathVariable("userID") UUID id){
        return toDoListService.findAllByUser(id);
    }
}