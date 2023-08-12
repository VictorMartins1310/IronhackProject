package com.bootcamp.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id
    private Long taskID;
    private String task;
    private Boolean status;
}
