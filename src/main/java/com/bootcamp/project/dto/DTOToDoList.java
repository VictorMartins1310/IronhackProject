package com.bootcamp.project.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class DTOToDoList {
    private Date creatonDate;
    @NotNull
    @NotBlank
    private String todoListName;
    private Boolean active;
}