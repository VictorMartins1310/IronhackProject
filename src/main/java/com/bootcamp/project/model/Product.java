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
    private Boolean status = false;

    public Boolean productBought(int qty){
        this.qty -= qty;
        this.status = this.qty <= 0;
        return status;
    }

    public BigDecimal totalPrice(){ return new BigDecimal(qty).multiply(price); }
}