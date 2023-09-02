package com.bootcamp.project;

import com.bootcamp.project.model.*;
import com.bootcamp.project.service.ShoppingListService;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

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

            User admin = userService.newAdmin("Admin@mail.de", "badPassword");
            User user = userService.newUser("User@mail.de", "badPassword");
        }
    }
}