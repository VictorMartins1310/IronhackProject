package com.bootcamp.project.model;

import com.bootcamp.project.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Date;
import java.util.List;

@Entity
@Data
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

    @OneToMany
    private List<ShoppingList> shopping;
    @OneToMany()
    private List<TaskList> task;

    public ToDoList(String todoListName, User user) {
        this.todoListName = todoListName;
        this.user = user;
        this.active = true;
        this.creatonDate = new Date();
    }
}