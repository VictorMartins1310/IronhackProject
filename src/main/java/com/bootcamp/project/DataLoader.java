package com.bootcamp.project;

import com.bootcamp.project.model.Role;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {


    private final UserService userService;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        long test = userService.qtyUsers();
        if (test == 0) {
            userService.addRole("ROLE_USER");
            userService.addRole("ROLE_ADMIN");

            userService.newAdmin(new User(null, "VictorMartins@mail.de",
                    "badPassword",
                    "Victor",
                    "Martins",
                    "1987-10-13",
                    new ArrayList<>()));
            userService.newUser("victor@mail.de", "badPassword");
        }
    }
}