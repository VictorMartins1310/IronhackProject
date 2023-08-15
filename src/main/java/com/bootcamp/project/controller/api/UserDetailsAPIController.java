package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "api")
public interface UserDetailsAPIController{
    final String route = "users/{id}/d";
    @GetMapping(value = route)
    Object showDetails(@PathVariable(name = "id") UUID id);
    //@PutMapping(value = route)
    //Object updateDetails(String firstName, String lastName, String birthDate);
    @PostMapping(value = route) // TODO if make sense
    Object updateDetails(@PathVariable(name = "id") UUID id, UserDetails userDetails);
    @PutMapping(value = route)
    Object putupdateDetails(@PathVariable(name = "id") UUID id, UserDetails userDetails);
}
