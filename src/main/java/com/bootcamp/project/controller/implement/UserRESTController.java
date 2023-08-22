package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.UserController;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "rest")
public class UserRESTController implements UserController {
    final UserService userService;

    @PostMapping(value = route + "/new")
    public User newUser(@RequestBody User user){
        return userService.newUser(user);
    }
    @GetMapping(value = route)
    public List<User> showAllUsers(){
        return userService.showUsers();
    }

    // User Details Part

    @GetMapping(value = details)
    public User showDetails(@PathVariable(name = "id") UUID id){
        return userService.findUserDetailsByUserID(id);
    }
    @PatchMapping(value = details)
    public User updateDetails(@PathVariable(name = "id") UUID id, @RequestBody User userDetails){
        return userService.updateDetails(id, userDetails);
    }
}