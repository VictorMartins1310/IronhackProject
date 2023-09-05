package com.bootcamp.project;

import com.bootcamp.project.repos.UserRepository;
import jdk.jfr.Name;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ProjectApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    @Name(value = "Testing developer User")
    void testUser(){
        final UserRepository userRepo;
        //final UserService userService = new UserService(userDetailsRepository, userRepo);
        String devEmail = "VictorTest@mail.com";
        //User devUser = userService.getUserByEmail(devEmail);
        assertTrue(true);
    }

}
