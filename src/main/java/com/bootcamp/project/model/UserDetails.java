package com.bootcamp.project.model;

import jakarta.persistence.TableGenerator;
import jakarta.persistence.OneToOne;
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails extends User{
    private String firstName;
    private String lastName;
    private String birthDate;
    @OneToOne(targetEntity = User.class)
    private User user;
}
