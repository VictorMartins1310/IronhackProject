package com.bootcamp.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity(name = "User")
@Data
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userID;
    private String email;
    private String password;
}
