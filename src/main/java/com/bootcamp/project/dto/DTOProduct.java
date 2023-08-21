package com.bootcamp.project.dto;

import com.bootcamp.project.model.ProductType;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class DTOProduct {
    private String name;
    private String brand;
    private BigDecimal price;
    private int qty;
    private ProductType type;
}