package com.bootcamp.project;

import com.bootcamp.project.model.User;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {


    private final UserService userService;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        userService.addRole("ROLE_USER");
        userService.addRole("ROLE_ADMIN");

        userService.newAdmin(new User(null,"email", "username",
         "password",
        "firstName",
        "lastName",
        "birthDate",
                new ArrayList<>()));


    }
}