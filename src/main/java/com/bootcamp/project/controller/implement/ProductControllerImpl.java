package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.ProductController;
import com.bootcamp.project.dto.ProductDTO;
import com.bootcamp.project.dto.ShoppingListDTO;
import com.bootcamp.project.model.Product;
import com.bootcamp.project.service.ProductService;
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
    private final ProductService productService;
    @PostMapping(value = "/{idOfShoppingList}/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingListDTO addProduct(@PathVariable("idOfShoppingList") Long todoID, @RequestBody ProductDTO productDTO){
        return shoppingService.addProdut2List(todoID, productDTO);
    }
    @GetMapping(value = "/{idOfShoppingList}/products")
    public List<ProductDTO> getAllProductsOfShoppingList(@PathVariable("idOfShoppingList") Long id){
        return shoppingService.getAllProductsDTOOfShoppingList(id);
    }

    @Override
    @PatchMapping(value = "/{idOfShoppingList}/products/{idOfProduct}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean boughtProduct(@PathVariable("idOfProduct") Long idOfProduct, int qty) {
        productService.productsBought(idOfProduct, qty);
        return true;
        //TODO
    }

    @Override
    @PatchMapping(value = "/{idOfShoppingList}/products/{idOfProduct}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@PathVariable("idOfProduct") Long idOfProduct) {
        return null;
        //TODO
    }
}