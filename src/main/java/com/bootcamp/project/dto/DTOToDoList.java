package com.bootcamp.project.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DTOToDoList {
    @NotBlank
    @Max(message = "Reached Maximum of (64) Characters", value = 64)
    private String todoListName;
}