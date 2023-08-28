package com.bootcamp.project.dto;

import jakarta.validation.constraints.Max;
import lombok.Data;

@Data
public class ShoppingListDTO {
    @Max(message = "Reached Maximum of (64) Characters", value = 64)
    private String marketName;
}