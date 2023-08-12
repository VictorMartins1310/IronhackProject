package com.bootcamp.project.repos;

import com.bootcamp.project.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<ToDoList, Long> {
}
