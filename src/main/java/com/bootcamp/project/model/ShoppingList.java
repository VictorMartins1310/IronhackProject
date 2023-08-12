package com.bootcamp.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class ShoppingList {
    @Id
    private Long shoppingListID;
    private String marketName;
    private Date creationDate;
    @ManyToOne
    private ToDoList toDoList;
}
