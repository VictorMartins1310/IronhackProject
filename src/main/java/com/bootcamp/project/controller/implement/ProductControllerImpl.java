package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.ProductController;
import com.bootcamp.project.dto.DTOProduct;
import com.bootcamp.project.dto.DTOShoppingList;
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
    public DTOShoppingList addProduct(@PathVariable(shoppingLID) Long todoID, @RequestBody DTOProduct productDTO){
        return shoppingService.addProdut2List(todoID, productDTO);
    }
    @GetMapping(value = "/{" + shoppingLID + "}/products")
    public List<DTOProduct> getAllProductsOfShoppingList(@PathVariable(shoppingLID) Long id){
        return shoppingService.getAllProductsDTOOfShoppingList(id);
    }
}