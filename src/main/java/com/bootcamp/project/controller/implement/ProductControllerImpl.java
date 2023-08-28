package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.ProductController;
import com.bootcamp.project.dto.ProductDTO;
import com.bootcamp.project.dto.ShoppingListDTO;
import com.bootcamp.project.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "products", value = "todolist/shoppinglist")
public class ProductControllerImpl implements ProductController {
    private final ShoppingListService shoppingService;
    @PostMapping(value = "/{"+ shoppingLID + "}/products/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingListDTO addProduct(@PathVariable(shoppingLID) Long todoID, @RequestBody ProductDTO productDTO){
        return shoppingService.addProdut2List(todoID, productDTO);
    }
    @GetMapping(value = "/{" + shoppingLID + "}/products")
    public List<ProductDTO> getAllProductsOfShoppingList(@PathVariable(shoppingLID) Long id){
        return shoppingService.getAllProductsDTOOfShoppingList(id);
    }

    @Override
    public void boughtProduct(Long idOfProduct, int qty) {
        // TODO
    }

    @Override
    public Object updateProduct() {
        return null; //TODO
    }
}