package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.UserController;
import com.bootcamp.project.dto.UserDetailsDTO;
import com.bootcamp.project.dto.LoginDTO;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(name = "users", value = "users")
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDetailsDTO newUser(@RequestBody LoginDTO loginData){
        return userService.newUserDTO(loginData.getEmail(), loginData.getPassword());
    }
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDetailsDTO showDetails(@PathVariable(name = "id") UUID id){
        return userService.findUserDetailsByUserIDDTO(id);
    }
    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDetailsDTO updateDetails(@PathVariable(name = "id") UUID id, @RequestBody UserDetailsDTO userDetails){
        return userService.updateDetailsDTO(id, userDetails);
    }
    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public User getMine(){
        return userService.getUserByUserEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}