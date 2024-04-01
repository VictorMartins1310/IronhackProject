package com.bootcamp.project.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
public class RegisterDTO extends UserDetailsDTO{
    @NotBlank(message = "Password is Mandatory")
    private String password;
}


