package com.bootcamp.project.mappers;

import com.bootcamp.project.dto.TaskListDTO;
import com.bootcamp.project.model.TaskList;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskListMapper extends ToDoListMapper{
    TaskListDTO toDto (TaskList dto);
    List<TaskListDTO> toDtos (List<TaskList> dto);
    TaskList toEntity (TaskListDTO entity);
}
