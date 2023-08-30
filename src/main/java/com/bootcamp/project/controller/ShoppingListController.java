package com.bootcamp.project.controller;

import com.bootcamp.project.dto.ShoppingListDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface ShoppingListController {
    Object newShoppingList(ShoppingListDTO shoppingList);
    Object showShoppingList(Long id);
    void updateShoppingList(Long id);
    Object showShoppingLists();
}