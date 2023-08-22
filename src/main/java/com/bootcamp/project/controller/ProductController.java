package com.bootcamp.project.controller;

import com.bootcamp.project.model.Product;
import org.springframework.web.bind.annotation.*;

public interface ProductController {
    String userID = "uuid";
    String shoppingLID = "shoppingid";
    String routeAdd = "products";
    @PostMapping(value = "/{"+ shoppingLID + "}/" + routeAdd +"/new")
    Object addProduct(@PathVariable(shoppingLID) Long todoID, @RequestBody Product product);
    @GetMapping(value = "/{" + shoppingLID + "}/" + routeAdd)
    Object getAllProductsOfShoppingList(@PathVariable(shoppingLID) Long id);
}