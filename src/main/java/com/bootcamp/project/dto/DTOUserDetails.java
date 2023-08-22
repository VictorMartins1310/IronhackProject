package com.bootcamp.project.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class DTOUserDetails {
    @NotBlank
    @Max(message = "Reached Maximum of (64) Characters", value = 64)
    private String firstName;
    @NotBlank
    @Max(message = "Reached Maximum of (128) Characters", value = 128)
    private String lastName;
    @Max(message = "Formated Date: YYYY-MM-DD", value = 10)
    private String birthDate;
}
