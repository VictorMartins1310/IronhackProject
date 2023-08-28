package com.bootcamp.project.controller;

import com.bootcamp.project.dto.LoginDTO;

import java.util.UUID;

public interface UserController {
    Object newUser(LoginDTO loginData);
    // UserDetails Part
    Object showDetails(UUID id);
    Object getMine();
}