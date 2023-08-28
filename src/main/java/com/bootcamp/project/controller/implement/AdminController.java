package com.bootcamp.project.controller.implement;

import com.bootcamp.project.dto.DTOUserDetails;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(name = "admin", value = "admin")
public class AdminController {
    private final UserService userService;
    @GetMapping("/users")
    public List<DTOUserDetails> showAllUsers(){ return userService.showUsers(); }
    @GetMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public User showDetails(@PathVariable(name = "id") UUID id){
        return userService.findUserDetailsByUserID(id);
    }
}