package com.bootcamp.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class TaskList extends ToDoList{
    @OneToMany
    private List<Task> tasks;

    public void addTask(Task newTask){
        tasks.add(newTask);
    }
}
