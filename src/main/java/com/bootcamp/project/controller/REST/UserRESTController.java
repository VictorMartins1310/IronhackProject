package com.bootcamp.project.controller.REST;

import com.bootcamp.project.controller.API.UserAPIController;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "rest")
public class UserRESTController implements UserAPIController {
    final UserService userService;
    @PostMapping(value = route + "/new")
    public User newUser(@RequestBody User user){
        return userService.newUser(user);
    }
    @GetMapping(value = route)
    public List<User> showAllUsers(){
        return userService.showUsers();
    }
}
