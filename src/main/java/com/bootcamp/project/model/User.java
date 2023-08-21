package com.bootcamp.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userID;
    @NotBlank(message = "E-Mail is Mandatory")
    private String email;
    @NotBlank(message = "Password is Mandatory")
    private String password;
    // User Details
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String birthDate;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public void updateDetails(String email, String firstName, String lastName, String birthDate){
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
    }
}
