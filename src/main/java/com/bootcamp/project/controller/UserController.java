package com.bootcamp.project.controller;

import com.bootcamp.project.dto.LoginDTO;
import com.bootcamp.project.dto.UserDetailsDTO;

public interface UserController {
    Object newUser(LoginDTO loginData);
    Object updateDetailsOnRegister(UserDetailsDTO userDetails);
    Object showDetails();
    Object updateDetails(UserDetailsDTO userDetails);
    Object getMine();
}