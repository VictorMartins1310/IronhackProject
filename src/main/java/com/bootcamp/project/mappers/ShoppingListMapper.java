package com.bootcamp.project.mappers;

import com.bootcamp.project.dto.DTOShoppingList;
import com.bootcamp.project.model.ShoppingList;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ShoppingListMapper {
    DTOShoppingList toDto (ShoppingList dto);
    ShoppingList toEntity (DTOShoppingList entity);
}