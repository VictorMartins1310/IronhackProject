package com.bootcamp.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity(name = "TaskList")
@Table(name = "TaskList")
public class TaskList extends ToDoList{
    @OneToMany
    private List<Task> task ;
}
