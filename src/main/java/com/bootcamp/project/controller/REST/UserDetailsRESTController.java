package com.bootcamp.project.controller.REST;

import com.bootcamp.project.controller.API.UserDetailsAPIController;
import com.bootcamp.project.model.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(name = "userDetails", value = "api")
public class UserDetailsRESTController implements UserDetailsAPIController {
    @PutMapping(name = route + "/users/{id}")
    public UserDetails updateDetails(String firstName, String lastName, String birthDate){
        return null;
    }
    @PostMapping(name = route + "/users/{id}")
    public UserDetails updateDetails(UserDetails userDetails){
        return null;
    }
    @GetMapping(name = route + "/users/{id}/details")
    public UserDetails showDetails(@PathVariable(name = "id") UUID id){
        return null; //TODO Develop here
    }
}
