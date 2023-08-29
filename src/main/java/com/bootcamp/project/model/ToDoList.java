package com.bootcamp.project.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Entity
@RequiredArgsConstructor
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoListID;
    private Date creationDate;
    private String todoListName;
    protected Boolean active; // If False it can be deleted ob DB
    @ManyToOne
    private User user;
    public ToDoList(String todoListName, User user) {
        this.todoListName = todoListName;
        this.user = user;
        this.active = true;
        this.creationDate = new Date();
    }
    /** Function that deactivate an List */
    public void deactivateList(){ this.active = false; }
}