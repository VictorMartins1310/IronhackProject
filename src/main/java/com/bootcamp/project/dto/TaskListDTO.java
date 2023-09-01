package com.bootcamp.project.dto;

import com.bootcamp.project.model.Task;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class TaskListDTO extends ToDoListDTO{
    //private List<Task> tasks = new ArrayList<>();
}