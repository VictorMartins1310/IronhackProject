package com.bootcamp.project.dto;

import jakarta.validation.constraints.NotNull;

public class DTOUser {
    @NotNull
    private String email;
    @NotNull
    private String password;
    // User Details
    private String firstName;
    private String lastName;
    private String birthDate;
}
