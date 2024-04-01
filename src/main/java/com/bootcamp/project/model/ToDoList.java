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
    protected Long todoListID;
    protected Date creationDate = new Date();
    protected String todoListName;
    protected Boolean active = true; // If False it can be deleted on DB
    @ManyToOne
    private User user;
    public ToDoList(String todoListName, User user) {
        this.todoListName = todoListName;
        this.user = user;
    }
    /** Function that deactivate a List */
    public void deactivateList(){ this.active = false; }
}