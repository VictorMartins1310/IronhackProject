package com.bootcamp.project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class TaskList extends ToDoList{
    @OneToMany
    private List<Task> tasks;

    public void addTask(Task newTask){ tasks.add(newTask); }
    public TaskList(Long todoListID, Date creatonDate, String todoListName, Boolean active, User user) {
        super(todoListID, creatonDate, todoListName, active, user);
        this.tasks = new ArrayList<>();
    }
}