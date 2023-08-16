package com.bootcamp.project.controller.rest;

import com.bootcamp.project.controller.api.UserAPIController;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    // User Details Part

    @GetMapping(value = routeDetails)
    public User showDetails(@PathVariable(name = "id") UUID id){
        return userService.findUserDetailsByUserID(id);
    }
    @PutMapping(value = routeDetails)
    public User updateDetails(@PathVariable(name = "id") UUID id, @RequestBody User userDetails){
        return userService.updateDetails(id, userDetails);
    }
}