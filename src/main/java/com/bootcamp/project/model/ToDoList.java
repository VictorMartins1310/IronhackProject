package com.bootcamp.project.model;

import com.bootcamp.project.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name = "TodoList")
@Data
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoListID;
    private Date creatonDate;
    private String todoListName;
    private Boolean active;
    @ManyToOne
    private User user;
}