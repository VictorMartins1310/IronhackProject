package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.ShoppingList;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(name = "shoppingListAPI", value = "api")
public interface ShoppingListAPIController {
    String rootTodo = "todolist";
    String rootShoppingList = rootTodo + "/shoppinglist";
    String userID = "uuid";
    String shoppingLID = "shoppingid";
    /** Get all Products to buy in the ShoppingList
     * @param id
     * @return
     */
    @PostMapping(value = rootShoppingList + "/user/{" + userID + "}/new")
    Object newShoppingList(@PathVariable(userID) UUID uuid, @RequestBody ShoppingList shoppingList);
}