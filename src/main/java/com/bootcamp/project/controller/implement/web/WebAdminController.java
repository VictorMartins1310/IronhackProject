package com.bootcamp.project.controller.implement.web;

import com.bootcamp.project.model.Role;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * This Controller is for Administration
 * Main Functions:
 *          - Listing all Users
 *          - Delete a specific user
 *          - Create a Role
 */
@RequiredArgsConstructor
@Controller
@RequestMapping(name = "webadmin", value = "web/admin")
public class WebAdminController {
    private final UserService userService;

    /** Save a new role
     * @param role role to be saved
     */
    @PostMapping(value = "/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public Role saveRole(@RequestBody String role) { return userService.addRole(role); }
    @GetMapping(value ="/users")
    public List<User> showAllUsers(){ return userService.showUsers(); }
    @GetMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User showDetails(@PathVariable(name = "id") UUID id){
        return userService.findByUserID(id);
    }
    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserByID(@PathVariable(name = "id") UUID id){
        userService.deleteUserByID(id);
    }
}