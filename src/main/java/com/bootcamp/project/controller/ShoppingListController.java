package com.bootcamp.project.controller;

import com.bootcamp.project.dto.ShoppingListDTO;

import java.util.UUID;

public interface ShoppingListController {
    String rootShoppingList = "/shoppinglist";
    String userID = "uuid";
    String shoppingLID = "shoppingid";
    Object newShoppingList(UUID uuid, ShoppingListDTO shoppingList);
}