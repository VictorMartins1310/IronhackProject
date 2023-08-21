package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api")
public interface ProductAPIController{
    String rootTodo = "todolist";
    String rootShoppingList = rootTodo + "/shoppinglist";
    String userID = "uuid";
    String shoppingLID = "shoppingid";
    String routeAdd = "products";
    @PostMapping(value = rootShoppingList + "/{"+ shoppingLID + "}/" + routeAdd +"/new")
    Object addProduct(@PathVariable(shoppingLID) Long todoID, @RequestBody Product product);
    @GetMapping(value = rootShoppingList + "/{" + shoppingLID + "}/" + routeAdd)
    Object getAllProductsOfShoppingList(@PathVariable(shoppingLID) Long id);
}