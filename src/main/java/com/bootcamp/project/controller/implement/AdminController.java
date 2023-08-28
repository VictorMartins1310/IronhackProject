package com.bootcamp.project.controller.implement;

import com.bootcamp.project.model.User;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(name = "admin", value = "admin")
public class AdminController {
    private final UserService userService;
    @GetMapping("/users")
    public List<User> showAllUsers(){ return userService.showUsers(); }
    @GetMapping(value = "/users/{id}")
    public User showDetails(@PathVariable(name = "id") UUID id){
        return userService.findUserDetailsByUserID(id);
    }
}