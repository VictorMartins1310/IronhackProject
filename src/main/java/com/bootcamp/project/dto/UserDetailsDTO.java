package com.bootcamp.project.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class UserDetailsDTO {
    @NotBlank(message = "E-Mail is Mandatory")
    @NotNull(message = "E-Mail is Mandatory")
    @Email(message = "E-Mail dont Follow rules")
    protected String email;
  //  @NotBlank
    @Max(message = "Reached Maximum of (64) Characters", value = 64)
    protected String firstName;
  //  @NotBlank
    @Max(message = "Reached Maximum of (128) Characters", value = 128)
    protected String lastName;
    @Max(message = "Formatted Date: YYYY-MM-DD", value = 10)
    protected LocalDate birthDate;
}
