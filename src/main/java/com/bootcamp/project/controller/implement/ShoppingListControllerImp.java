package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.ShoppingListController;
import com.bootcamp.project.dto.DTOShoppingList;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "shoppinglist", value = "todolist/shoppinglist")
public class ShoppingListControllerImp implements ShoppingListController{
    private final ShoppingListService shoppingService;
    @GetMapping(value = rootShoppingList + "/{" + shoppingLID + "}")
    public ShoppingList showShoppingList(@PathVariable(shoppingLID) Long id){
        return shoppingService.getShoppingList(id); // TODO Check if need change to TDO??
    }

    @PostMapping(value = rootShoppingList + "/user/{userID}")
    public DTOShoppingList newShoppingList(@PathVariable("userID") UUID uuid, @RequestBody DTOShoppingList shoppingList){
        return shoppingService.newShoppingList(uuid, shoppingList);
    }
}