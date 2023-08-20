package com.bootcamp.project.controller.rest;

import com.bootcamp.project.controller.api.ShoppingListAPIController;
import com.bootcamp.project.controller.api.TodoListAPIController;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "rest")
public abstract class ShoppingListRESTController implements ShoppingListAPIController {
    private final ShoppingListService shoppingService;
    @GetMapping(value = rootShoppingList + "/{" + shoppingLID + "}")
    public ShoppingList showShoppingList(@PathVariable(shoppingLID) Long id){
        return shoppingService.getShoppingList(id);
    }

    @PostMapping(value = rootShoppingList + "/{"+ shoppingLID + "}/new")
    public ShoppingList newShoppingList(@PathVariable(shoppingLID) Long todoID, @RequestBody ShoppingList shoppingList){
        return shoppingService.newShoppingList(todoID, shoppingList);
    }
}