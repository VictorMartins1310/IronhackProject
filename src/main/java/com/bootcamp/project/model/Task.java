package com.bootcamp.project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskID;
    private String task;
    /** True means Done, False to be Do */
    private Boolean status;
    public Task(String task) {
        this.task = task;
        this.status = true;
    }

    public void taskDone(){ this.status = false; }
}