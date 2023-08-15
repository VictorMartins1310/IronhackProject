package com.bootcamp.project.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ShoppingList extends ToDoList{
    private String marketName;
    @OneToMany
    private List<Product> products;
}
