package com.bootcamp.project.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoListID;
    private Date creatonDate;
    @NotNull
    @NotBlank
    private String todoListName;
    private Boolean active;
    @ManyToOne
    @NotNull
    private User user;
    public ToDoList(String todoListName, User user) {
        this.todoListName = todoListName;
        this.user = user;
        this.active = true;
        this.creatonDate = new Date();
    }
    public void deactivateList(){
        this.active = false;
    }
}