package com.bootcamp.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
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

    public ShoppingList(Long todoListID, Date creatonDate, String todoListName, Boolean active, User user, String marketName) {
        super(todoListID, creatonDate, todoListName, active, user);
        this.marketName = marketName;
        this.products = new ArrayList<>();
    }
}