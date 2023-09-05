package com.bootcamp.project.controller;

import com.bootcamp.project.dto.LoginDTO;
import com.bootcamp.project.dto.UserDetailsDTO;
import com.bootcamp.project.model.User;

import java.text.ParseException;

public interface UserController {
    Object newUser(LoginDTO loginData);
    Object updateDetailsOnRegister(User userDetails) throws ParseException;
    Object updateDetails(User userDetails) throws ParseException;
    Object showDetails();
    Object getMine();
}