package com.bootcamp.project.mappers;

import com.bootcamp.project.dto.DTOUser;
import com.bootcamp.project.dto.DTOUserDetails;
import com.bootcamp.project.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserDetailsMapper {
    UserDetailsMapper toDto (DTOUserDetails dto);
    DTOUserDetails toEntity (User entity);
}