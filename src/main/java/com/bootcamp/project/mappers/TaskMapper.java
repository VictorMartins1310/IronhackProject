package com.bootcamp.project.mappers;

import com.bootcamp.project.dto.DTOTask;
import com.bootcamp.project.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {
    TaskMapper toDto (DTOTask dto);
    DTOTask toEntity (Task entity);
}