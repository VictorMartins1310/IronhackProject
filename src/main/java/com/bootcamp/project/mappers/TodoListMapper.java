package com.bootcamp.project.mappers;


import com.bootcamp.project.dto.*;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.model.TaskList;
import com.bootcamp.project.model.ToDoList;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TodoListMapper {
    // TodoList Mapping Section
    ToDoListDTO toDto (ToDoList dto);
    TaskListDTO toDto (TaskList dto);
    ShoppingListDTO toDto(ShoppingList dto);
    ShoppingListProductsDTO toDTO(ShoppingList dto);
    TaskListTasksDTO toDTO(TaskList dto);
    List<ToDoListDTO> toDto(List<ToDoList> dto);

    // TaskList Mapping Section
    List<TaskListDTO> toTaskListsDtos (List<TaskList> dtos);

    List<ShoppingListDTO> toShoppingListDtos (List<ShoppingList> dtos);

}