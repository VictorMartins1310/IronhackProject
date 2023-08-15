package com.bootcamp.project.controller.API;

import com.bootcamp.project.model.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "todoListAPI", value = "api")
public interface UserDetailsAPIController{
    String route = "userdetails";
    @PutMapping(name = "users/{id}" + route)
    Object updateDetails(String firstName, String lastName, String birthDate);
    @PostMapping(name = "users/{id}" + route)
    Object updateDetails(UserDetails userDetails);
}
