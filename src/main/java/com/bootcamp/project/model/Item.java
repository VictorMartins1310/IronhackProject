package com.bootcamp.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {
    @Id
    private Long itemID;
}
