package com.bootcamp.project.controller.REST;

import com.bootcamp.project.controller.API.UserAPIController;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "rest")
public class UserRESTController implements UserAPIController {
    final UserService userService;
    @PostMapping(value = route + "/new")
    public User newUser(@RequestBody User user){
        return userService.newUser(user);
    }

}
