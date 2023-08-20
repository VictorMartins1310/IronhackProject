package com.bootcamp.project.controller.rest;

import com.bootcamp.project.controller.api.ProductAPIController;
import com.bootcamp.project.controller.api.ShoppingListAPIController;
import com.bootcamp.project.controller.api.TaskAPIController;
import com.bootcamp.project.model.Product;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "rest")
public abstract class ProductRESTController implements ProductAPIController {
    private final ShoppingListService shoppingService;
    @PostMapping(value = rootShoppingList + "/{"+ shoppingLID + "}/products/new")
    public ShoppingList addProduct(@PathVariable(shoppingLID) Long todoID, @RequestBody Product product){
        return shoppingService.addProdut2List(todoID, product);
    }
    @GetMapping(value = rootShoppingList + "/{" + shoppingLID + "}/products")
    public List<Product> getAllProductsOfShoppingList(@PathVariable(shoppingLID) Long id){
        return shoppingService.getAllProductsOfShoppingList(id);
    }

}
