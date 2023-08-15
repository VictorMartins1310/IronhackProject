package com.bootcamp.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    private Long articleID;
    private String name;
    private String brand;
    private ProductType type;
}
