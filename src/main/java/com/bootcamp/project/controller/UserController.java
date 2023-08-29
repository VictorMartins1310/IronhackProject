package com.bootcamp.project.controller;

import com.bootcamp.project.dto.LoginDTO;
import com.bootcamp.project.dto.UserDetailsDTO;

import java.util.UUID;

public interface UserController {
    Object newUser(LoginDTO loginData);
    Object showDetails(UUID id);
    Object updateDetails(UUID id, UserDetailsDTO userDetails);
    Object getMine();
}