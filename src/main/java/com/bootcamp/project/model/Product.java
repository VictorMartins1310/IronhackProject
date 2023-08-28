package com.bootcamp.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;
    private String name;
    private String brand;
    private BigDecimal price;
    private int qty;
    private ProductType type;
    /** True means products bought, False means to be buyed */
    private Boolean status;

    public Product(String name, String brand, BigDecimal price, int qty, ProductType type) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.qty = qty;
        this.type = type;
        this.status = false;
    }

    public Boolean productBought(int qty){
        this.qty -= qty;
        this.status = this.qty >= 0;
        return status;
    }

    public BigDecimal totalPrice(){ return new BigDecimal(qty).multiply(price); }
}