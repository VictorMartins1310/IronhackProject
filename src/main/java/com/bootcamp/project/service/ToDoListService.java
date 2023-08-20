package com.bootcamp.project.service;

import com.bootcamp.project.exception.ProjectException;
import com.bootcamp.project.model.ToDoList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.repos.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ToDoListService {
    private final ToDoListRepository toDoListRepository;
    private final UserService userService;
    public ToDoList newTodoList(UUID id, ToDoList todo) {
        User user = userService.findUserDetailsByUserID(id);
        ToDoList newTodoList = new ToDoList(todo.getTodoListName(), user);
        return toDoListRepository.save(newTodoList);
    }
    public ToDoList findById(Long id){
        return toDoListRepository.findById(id).get();
    }
    public List<ToDoList> findByUserId(UUID userID){
        User user = userService.getUser(userID);
        if (toDoListRepository.findAllByUser(user).isEmpty()) {
            throw new ProjectException("NO TodoLIST");
        }
        return toDoListRepository.findAllByUser(user);
    }
}