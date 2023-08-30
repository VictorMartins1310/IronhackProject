package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.UserController;
import com.bootcamp.project.dto.UserDetailsDTO;
import com.bootcamp.project.dto.LoginDTO;
import com.bootcamp.project.mappers.UserDetailsMapper;
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

    private final UserDetailsMapper userDetailsMapper;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDetailsDTO newUser(@RequestBody LoginDTO loginData){
        return userDetailsMapper.toDto(userService.newUser(loginData.getEmail(), loginData.getPassword()));
    }
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDetailsDTO showDetails(@PathVariable(name = "id") UUID id){
        return userDetailsMapper.toDto(userService.findByUserID(id));
    }
    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDetailsDTO updateDetails(@PathVariable(name = "id") UUID id, @RequestBody UserDetailsDTO userDetails){
        User user = userDetailsMapper.toEntity(userDetails);
        return userDetailsMapper.toDto(userService.updateDetails(id, user));
    }
    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public User getMine(){
        return userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}