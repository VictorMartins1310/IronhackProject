package com.bootcamp.project.controller.implement;


import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("roles")
@RequiredArgsConstructor
public class RoleControllerImpl {// implements RoleController {

    /**
     * User service for accessing user data
     */
    private final UserService userService;

    /**
     * Save a new role
     *
     * @param role role to be saved
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRole(@RequestBody String role) {
        userService.addRole(role);
    }

    /**
     * Add a role to a user
     *
     * @param roleToUserDTO DTO containing the username and role name
     */
/*    @PostMapping("addtouser")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRoleToUser(@RequestBody RoleToUserDto roleToUserDTO) {
        userService.addRole(roleToUserDTO.getUsername(), roleToUserDTO.getRoleName());
    }
*/
}