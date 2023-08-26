package com.bootcamp.project.controller;

import com.bootcamp.project.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(name = "users", value = "users")
public interface UserController {
    @PostMapping
    Object newUser(@RequestBody User user);

    /** Function for Admin
     * @return All Users
     */
    @GetMapping
    Object showAllUsers();

    // UserDetails Part

    @GetMapping(value = "/{id}")
    Object showDetails(@PathVariable(name = "id") UUID id);
    @PostMapping(value = "/{id}")
    Object updateDetails(@PathVariable(name = "id") UUID id, @RequestBody User userDetails);
    @GetMapping("me")
    User getMine();
}