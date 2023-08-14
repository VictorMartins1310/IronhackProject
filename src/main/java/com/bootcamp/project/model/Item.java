package com.bootcamp.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Item")
@Table(name = "Item")
public class Item {
    @Id
    private Long itemID;
    private String name;
    private String brand;
    private TypeItem type;
}
