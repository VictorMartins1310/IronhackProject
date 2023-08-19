package com.bootcamp.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;
    private String name;
    private String brand;
    private BigDecimal price;
    private int qty;
    private ProductType type;

    public BigDecimal totalPrice(){
        return new BigDecimal(qty).multiply(price);
    }
}
