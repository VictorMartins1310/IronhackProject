package com.bootcamp.project.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ToDoList {
    @Id
    private Long ID;
    private Date creatonDate;
    private String todoListName;
    @ManyToOne
    private User user;
}
