package com.bootcamp.project.controller.interfaces;

import com.bootcamp.project.dto.UserDetailsDTO;


public interface UserController {
    Object updateUserDetails(UserDetailsDTO userDetails);
    Object showDetails();
    Object getMine();
}