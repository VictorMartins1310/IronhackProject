package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.UserController;
import com.bootcamp.project.dto.DTOUser;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(name = "users", value = "users")
public class UserControllerImpl implements UserController {
    final UserService userService;

    @PostMapping
    public DTOUser newUser(@RequestBody User user){
        return userService.newUser(user);
    }
    @GetMapping
    public List<DTOUser> showAllUsers(){
        return userService.showUsers();
    }

    // User Details Part

    @GetMapping(value = "/{id}")
    public DTOUser showDetails(@PathVariable(name = "id") UUID id){
        return userService.findUserDetailsByUserID(id);
    }
    @PatchMapping(value = "/{id}")
    public DTOUser updateDetails(@PathVariable(name = "id") UUID id, @RequestBody DTOUser userDetails){
        return userService.updateDetails(id, userDetails);
    }

    @GetMapping("me")
    public User getMine(){
        return userService.getUserByUserEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}