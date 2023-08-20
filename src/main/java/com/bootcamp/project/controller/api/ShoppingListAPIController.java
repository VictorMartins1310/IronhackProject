package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.ShoppingList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "shoppingListAPI", value = "api")
public interface ShoppingListAPIController extends TodoListAPIController{
    String rootShoppingList = rootTodo + "/shoppinglist";
    String shoppingLID = "todoListid";
    /** Get all Products to buy in the ShoppingList
     * @param id
     * @return
     */
    @PostMapping(value = rootShoppingList + "/{" + shoppingLID + "}/new")
    Object newShoppingList(@PathVariable(shoppingLID) Long todoID, @RequestBody ShoppingList shoppingList);
}