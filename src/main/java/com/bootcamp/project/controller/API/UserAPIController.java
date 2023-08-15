package com.bootcamp.project.controller.API;

import com.bootcamp.project.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "usersAPI", value = "api")
public interface UserAPIController {
    String route = "users";
    @PostMapping(value = route + "/new")
    Object newUser(@RequestBody User user);
}