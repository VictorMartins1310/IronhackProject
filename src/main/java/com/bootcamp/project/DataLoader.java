package com.bootcamp.project;

import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {


    private final UserService userService;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        long qtyUsers = userService.qtyUsers();
        if (qtyUsers == 0) {
            userService.addRole("ROLE_ADMIN");
            userService.addRole("ROLE_USER");

            userService.newUser("6692c7ab-347e-4a6d-8fbf-99bcbf2c9cdd","Admin@mail.de", "badPassword");
            userService.newUser("6692c7ab-347e-4a6d-8fbf-99bcbf2c9cde","User@mail.de", "badPassword");        }
    }
}