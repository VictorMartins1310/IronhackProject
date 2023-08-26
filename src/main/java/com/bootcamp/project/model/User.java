package com.bootcamp.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@Data
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userID;
    private String email;
    private String password;
    // User Details
    private String firstName;
    private String lastName;
    private String birthDate;

    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();
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