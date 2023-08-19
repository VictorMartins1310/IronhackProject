package com.bootcamp.project.controller.rest;

import com.bootcamp.project.controller.api.ShoppingListAPIController;
import com.bootcamp.project.model.Product;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.model.ToDoList;
import com.bootcamp.project.service.ProductService;
import com.bootcamp.project.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "rest")
public class ShoppingListRESTController implements ShoppingListAPIController {
    private final ShoppingListService shoppingService;
    @GetMapping(value = route + "/{id}")
    public List<Product> getAllProductsOfShoppingList(@PathVariable("id") Long id){
        return shoppingService.getAllProductsOfShoppingList(id); //TODO
    }
    @GetMapping(value = route + "/users/{uuid}")
    public List<ShoppingList> getAllProductsOfShoppingList(@PathVariable("uuid") UUID uuid){
        return null; //
    }
    @PostMapping(value = route + "/{uuid}/new")
    public ShoppingList newShoppingList(@PathVariable("uuid") UUID uuid, @RequestBody ShoppingList shoppingList){
        Long id = 8L; // TODO Develop Method better (resolve better Endpoint), this is for Testing
        return shoppingService.newShoppingList(id, shoppingList);
    }

}