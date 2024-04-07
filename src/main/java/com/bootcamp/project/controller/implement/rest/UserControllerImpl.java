package com.bootcamp.project.controller.implement.rest;

import com.bootcamp.project.controller.abstracts.UserController;
import com.bootcamp.project.dto.RegisterDTO;
import com.bootcamp.project.dto.UserDetailsDTO;
import com.bootcamp.project.mappers.UserMapper;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public class UserControllerImpl extends UserController {
    public UserControllerImpl(UserService userService, UserMapper userMapper) {
        super(userService, userMapper);
    }

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDetailsDTO newUser(@RequestBody RegisterDTO registerData){
        return userMapper.toUserDetailsDto(userService.newUser(registerData.getEmail(), registerData.getPassword()));
    }

    @GetMapping(value = "userdetails")
    @ResponseStatus(HttpStatus.OK)
    public UserDetailsDTO showDetails(){
        return getUserDetails();
    }
    /** updateDetails
     Update authenticated User
     */
    @Override
    @PatchMapping(value = "userdetails")
    @ResponseStatus(HttpStatus.OK)
    public UserDetailsDTO updateUserDetails(@RequestBody UserDetailsDTO newUserDetails) {
        updateDetails(newUserDetails);
        return userMapper.toUserDetailsDto(userService.getAutenticatedUser());
    }
    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public User getMine(){
        return userService.getAutenticatedUser();
    }
}