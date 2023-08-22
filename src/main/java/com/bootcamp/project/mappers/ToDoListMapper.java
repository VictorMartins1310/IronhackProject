package com.bootcamp.project.mappers;


import com.bootcamp.project.dto.DTOToDoList;
import com.bootcamp.project.model.ToDoList;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ToDoListMapper {
    DTOToDoList toDto (ToDoList dto);
    ToDoList toEntity (DTOToDoList entity);
}