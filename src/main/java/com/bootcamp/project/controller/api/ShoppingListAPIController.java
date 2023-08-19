package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.model.ToDoList;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(name = "shoppingListAPI", value = "api")
public interface ShoppingListAPIController {
    String route = "todolist/shoppinglist";
    @GetMapping(value = route + "/{id}")
    Object getAllProductsOfShoppingList(@PathVariable("id") Long id);
    @PostMapping(value = route + "/{uuid}/new")
    Object newShoppingList(@PathVariable("uuid") UUID id, @RequestBody ShoppingList shoppingList);
    @GetMapping(value = route + "/users/{uuid}")
    Object getAllProductsOfShoppingList(@PathVariable("uuid") UUID uuid);
}