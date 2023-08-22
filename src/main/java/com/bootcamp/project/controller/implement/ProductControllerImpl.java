package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.ProductController;
import com.bootcamp.project.model.Product;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "products", value = "todolist/shoppinglist")
public class ProductControllerImpl implements ProductController {
    private final ShoppingListService shoppingService;
    @PostMapping(value = "/{"+ shoppingLID + "}/products/new")
    public ShoppingList addProduct(@PathVariable(shoppingLID) Long todoID, @RequestBody Product product){
        return shoppingService.addProdut2List(todoID, product);
    }
    @GetMapping(value = "/{" + shoppingLID + "}/products")
    public List<Product> getAllProductsOfShoppingList(@PathVariable(shoppingLID) Long id){
        return shoppingService.getAllProductsOfShoppingList(id);
    }
}