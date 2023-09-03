package com.bootcamp.project.repos;

import com.bootcamp.project.model.ToDoList;
import com.bootcamp.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
    List<ToDoList> findAllByUser(User user);
    List<ToDoList> findToDoListsByUser(User user);
    List<ToDoList> findAllByUserAndActive(User user, Boolean active);
}
