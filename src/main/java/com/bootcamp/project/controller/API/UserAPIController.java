package com.bootcamp.project.controller.API;

import com.bootcamp.project.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "usersAPI", value = "api")
public interface UserAPIController {
    String route = "users";
    @PostMapping(value = route + "/new")
    Object newUser(@RequestBody User user);
}