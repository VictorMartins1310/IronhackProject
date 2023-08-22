package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(name = "usersAPI", value = "api")
public interface UserAPIController {
    String route = "users";
    @PostMapping(value = route + "/new")
    Object newUser(@RequestBody User user);

    /** Function for Admin
     * @return All Users
     */
    @GetMapping(value = route)
    Object showAllUsers();

    // UserDetails Part

    String routeDetails = "users/{id}/d";
    @GetMapping(value = routeDetails)
    Object showDetails(@PathVariable(name = "id") UUID id);
    @PostMapping(value = routeDetails)
    Object updateDetails(@PathVariable(name = "id") UUID id, @RequestBody User userDetails);
}