package com.bootcamp.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Task")
@Table(name = "Task")
public class Task {
    @Id
    private Long taskID;
    private String task;
    private Boolean status;
}
