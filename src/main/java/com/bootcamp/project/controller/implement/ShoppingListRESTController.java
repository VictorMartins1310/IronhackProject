package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.ShoppingListController;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "rest")
public class ShoppingListRESTController implements ShoppingListController {
    private final ShoppingListService shoppingService;
    @GetMapping(value = rootShoppingList + "/{" + shoppingLID + "}")
    public ShoppingList showShoppingList(@PathVariable(shoppingLID) Long id){
        return shoppingService.getShoppingList(id);
    }

    @PostMapping(value = rootShoppingList + "/user/{" + userID + "}/new")
    public ShoppingList newShoppingList(@PathVariable(userID) UUID uuid, @RequestBody ShoppingList shoppingList){
        return shoppingService.newShoppingList(uuid, shoppingList);
    }
}