package com.bootcamp.project.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "shoppingListAPI", value = "api")
public interface ShoppingListItemAPIController {
    String route = "shoppingList";
}