package com.bootcamp.project.service;

import com.bootcamp.project.model.ToDoList;
import com.bootcamp.project.repos.TodoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoListService {
    private final TodoListRepository todoListRepository;
    public List<ToDoList> findAll(){
        return todoListRepository.findAll();
    }
}
