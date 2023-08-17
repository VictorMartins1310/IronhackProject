package com.bootcamp.project.controller.rest;

import com.bootcamp.project.controller.api.ShoppingListAPIController;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "rest")
public class ShoppingListRESTController implements ShoppingListAPIController {
    private final ShoppingListService shoppingService;
    @PostMapping(value = route + "/new")
    public ShoppingList newShoppingList(@RequestBody ShoppingList shoppingList, Long id){
        return shoppingService.newShoppingList(id, shoppingList);
    }
}