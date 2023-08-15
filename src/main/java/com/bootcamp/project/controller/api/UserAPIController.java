package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "usersAPI", value = "api")
public interface UserAPIController {
    String route = "users";
    @PostMapping(value = route + "/new")
    Object newUser(@RequestBody User user);
    @GetMapping(value = route)
    Object showAllUsers();
}