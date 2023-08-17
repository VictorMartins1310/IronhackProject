package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.ShoppingList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "shoppingListAPI", value = "api")
public interface ShoppingListAPIController {
    String route = "shoppinglist";
    @PostMapping(value = route + "/new")
    Object newShoppingList(@RequestBody ShoppingList shoppingList, Long id);
}