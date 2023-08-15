package com.bootcamp.project.controller.rest;

import com.bootcamp.project.controller.api.UserDetailsAPIController;
import com.bootcamp.project.model.UserDetails;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "userDetailsREST", value = "rest")
public class UserDetailsRESTController implements UserDetailsAPIController {
    private final UserService userService;

    @GetMapping(value = route)
    public UserDetails showDetails(@PathVariable(name = "id") UUID id){
        return userService.findUserDetailsByUserID(id);
    }
    @PostMapping(value = route)
    public UserDetails updateDetails(@PathVariable(name = "id") UUID id, UserDetails userDetails){
        return userService.addDetails(userDetails);
    }
/*    @PutMapping(value = route)
    public UserDetails updateDetails(String firstName, String lastName, String birthDate){
        return null; // TODO Develop Here
    }
 */
    @PutMapping(value = route)
    public UserDetails putupdateDetails(@PathVariable(name = "id") UUID id, UserDetails userDetails){
        return userService.updateDetails(id, userDetails); // TODO Develop Here
    }
}
