package com.bootcamp.project.model;

import jakarta.persistence.TableGenerator;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "UserDetails")
@Table(name = "UserDetails")
public class UserDetails extends User{
    private String firstName;
    private String lastName;
    private String birthDate;
//    @OneToOne(targetEntity = User.class)
//    private User user;
}
