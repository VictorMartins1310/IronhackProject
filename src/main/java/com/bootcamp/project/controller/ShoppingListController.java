package com.bootcamp.project.controller;

import com.bootcamp.project.dto.ShoppingListDTO;

public interface ShoppingListController {
    Object newShoppingList(ShoppingListDTO shoppingList);
    Object showShoppingList(Long id);
    void updateShoppingList(Long id,String shplname, String marketName);
    Object showShoppingLists();
    Boolean deleteShoppingList(Long id);
}