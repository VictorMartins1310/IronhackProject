package com.bootcamp.project.mappers;

import com.bootcamp.project.dto.DTOUser;
import com.bootcamp.project.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    DTOUser toDto (User dto);
    User toEntity (DTOUser entity);
}