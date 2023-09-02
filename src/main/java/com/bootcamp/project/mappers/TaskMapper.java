package com.bootcamp.project.mappers;

import com.bootcamp.project.dto.TaskDTO;
import com.bootcamp.project.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {
    TaskDTO toDto (Task dto);
    List<TaskDTO> toDto (List<Task> dto);
    Task toEntity (TaskDTO entity);
}