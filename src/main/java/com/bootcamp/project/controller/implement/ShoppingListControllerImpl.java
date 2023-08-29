package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.ShoppingListController;
import com.bootcamp.project.dto.ShoppingListDTO;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "shoppinglist", value = "todolist/shoppinglist")
public class ShoppingListControllerImpl implements ShoppingListController{
    private final ShoppingListService shoppingService;
    @PostMapping(value = "/user/{userID}")
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingListDTO newShoppingList(@PathVariable("userID") UUID uuid, @RequestBody ShoppingListDTO shoppingList){
        return shoppingService.newShoppingList(uuid, shoppingList);
    }
    @GetMapping(value = "/{shoppingLID}")
    @ResponseStatus(HttpStatus.OK)
    public ShoppingList showShoppingList(@PathVariable("shoppingLID") Long id){
        return shoppingService.getShoppingList(id); // TODO Check if need change to TDO??
    }
    @PatchMapping(value = "/{shoppingLID}")
    @ResponseStatus(HttpStatus.OK)
    public void updateShoppingList(@PathVariable("shoppingLID") Long id){
        // TODO
    }
    @DeleteMapping(value = "/{shoppingLID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteShoppingList(@PathVariable("shoppingLID") Long id){
        // TODO
    }

}