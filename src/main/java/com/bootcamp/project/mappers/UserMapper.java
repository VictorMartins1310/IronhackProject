package com.bootcamp.project.mappers;

import com.bootcamp.project.dto.LoginDTO;
import com.bootcamp.project.dto.RegisterDTO;
import com.bootcamp.project.dto.UserDetailsDTO;
import com.bootcamp.project.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserDetailsDTO toUserDetailsDto(User dto);
    RegisterDTO toRegisterDto(User dto);
    RegisterDTO toRegisterDto(LoginDTO dto);
    LoginDTO toLoginDto(User dto);


    LoginDTO toLoginDTO(User dto);
    @Mapping(target = "userID", ignore = true)
    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "birthDate", ignore = true)
    User toEntity (LoginDTO entity);
    //TODO MAINTAIN

}