package com.bootcamp.project.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "ShoppingList")
@Table(name = "ShoppingList")
public class ShoppingList extends ToDoList{
    private String marketName;
    @OneToMany
    private List<Article> articles;

}
