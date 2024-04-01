package com.bootcamp.project.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LoginDTO extends UserDetailsDTO {
    @NotBlank(message = "E-Mail is Mandatory")
    @Email(message = "E-Mail dont Follow rules")
    private String email;
    @NotBlank(message = "Password is Mandatory")
    private String password;
}