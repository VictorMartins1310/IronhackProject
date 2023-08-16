package com.bootcamp.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userID;
    @NotNull
    private String email;
    @NotNull
    private String password;
    // User Details
    private String firstName;
    private String lastName;
    private String birthDate;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User updateDetails(String email, String firstName, String lastName, String birthDate){
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
        return this;
    }
}
