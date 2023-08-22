package com.bootcamp.project.controller;

import com.bootcamp.project.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(name = "usersAPI", value = "users")
public interface UserController {
    @PostMapping
    Object newUser(@RequestBody User user);

    /** Function for Admin
     * @return All Users
     */
    @GetMapping
    Object showAllUsers();

    // UserDetails Part

    String details = "/{id}/d";
    @GetMapping(value = details)
    Object showDetails(@PathVariable(name = "id") UUID id);
    @PostMapping(value = details)
    Object updateDetails(@PathVariable(name = "id") UUID id, @RequestBody User userDetails);
}