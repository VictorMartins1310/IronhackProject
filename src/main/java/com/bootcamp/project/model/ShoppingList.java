package com.bootcamp.project.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@RequiredArgsConstructor
public class ShoppingList extends ToDoList{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marketName;
    @OneToMany
    private List<Product> products  = new ArrayList<>();
    public void addProduct(Product product) { products.add(product); }
    public BigDecimal getTotal(){
        BigDecimal total = new BigDecimal("0.00");
        for (Product prod: products)
            total = total.add(prod.totalPrice());
        return total;
    }
    public ShoppingList(User user, String marketName) {
        super("Shopping List " + marketName, user);
        this.marketName = marketName;
    }
}