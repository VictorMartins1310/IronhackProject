package com.bootcamp.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class ShoppingList extends ToDoList{
    private String marketName;
    @OneToMany
    private List<Product> products;

    public void addProduct(Product product) { products.add(product); }
    public BigDecimal getTotal(){
        BigDecimal total = new BigDecimal("0.00");
        for (Product prod: products)
            total = total.add(prod.totalPrice());
        return total;
    }
}