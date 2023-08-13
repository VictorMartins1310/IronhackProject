package com.bootcamp.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class UserDetails extends User{
    private String firstName;
    private String lastName;
    private String birthDate;
    @OneToOne(targetEntity = User.class)
    private User user;
}
