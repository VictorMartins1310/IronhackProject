package com.bootcamp.project.mappers;

import com.bootcamp.project.dto.LoginDTO;
import com.bootcamp.project.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoginMapper {
    LoginDTO toDto (User dto);
    User toEntity (LoginDTO entity);
}