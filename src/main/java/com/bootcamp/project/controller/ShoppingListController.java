package com.bootcamp.project.controller;

import com.bootcamp.project.model.ShoppingList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(name = "shoppingListAPI", value = "todolist/shoppingList")
public interface ShoppingListController {
    String rootShoppingList = "/shoppinglist";
    String userID = "uuid";
    String shoppingLID = "shoppingid";
    /** Get all Products to buy in the ShoppingList
     * @param id
     * @return
     */
    @PostMapping(value = rootShoppingList + "/user/{" + userID + "}/new")
    Object newShoppingList(@PathVariable(userID) UUID uuid, @RequestBody ShoppingList shoppingList);
}