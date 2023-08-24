package com.bootcamp.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskID;
    private String task;
    /** True means Done, False to be Do */
    private Boolean status;
}
