package com.bootcamp.project.controller.abstracts;

import com.bootcamp.project.dto.UserDetailsDTO;
import com.bootcamp.project.mappers.UserMapper;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class UserController implements com.bootcamp.project.controller.UserController {
    protected final UserService userService;
    protected final UserMapper userMapper;
    public UserDetailsDTO getUserDetails(){
        return userMapper.toUserDetailsDto(userService.getAutenticatedUser());
    }
    public abstract UserDetailsDTO updateUserDetails(UserDetailsDTO newUserDetails);
    public void updateDetails(UserDetailsDTO newUserDetails) {
        userService.updateDetails(userService.getAutenticatedUser(), newUserDetails.getFirstName(), newUserDetails.getLastName(), newUserDetails.getBirthDate().toString());
    }
}