package com.bootcamp.project.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DTOToDoList {
    @NotNull
    @NotBlank
    private String todoListName;
}