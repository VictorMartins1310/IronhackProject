package com.bootcamp.project.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "todoListAPI", value = "api")
public interface ShoppingListAPIController {
    String route = "shoppinglist";
}
