package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.ProductController;
import com.bootcamp.project.dto.ProductDTO;
import com.bootcamp.project.dto.ShoppingListDTO;
import com.bootcamp.project.mappers.ProductMapper;
import com.bootcamp.project.mappers.ShoppingListMapper;
import com.bootcamp.project.model.Product;
import com.bootcamp.project.model.ShoppingList;
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

    private final ShoppingListMapper shoppingLMapper;
    private final ProductMapper productMapper;
    @PostMapping(value = "/{idOfShoppingList}/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingListDTO addProduct(@PathVariable("idOfShoppingList") Long todoID, @RequestBody ProductDTO productDTO){
        Product product = productMapper.toEntity(productDTO);
        return shoppingLMapper.toDto(shoppingService.addProdut2List(todoID, product));
    }
    @GetMapping(value = "/{idOfShoppingList}/products")
    public List<ProductDTO> getAllProductsOfShoppingList(@PathVariable("idOfShoppingList") Long id){
        ShoppingList shpL = shoppingService.getShoppingList(id);
        return productService.getAllProductsOfShoppingList(shpL).stream().map(productMapper::toDto).toList();
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
    @PatchMapping(value = "/{idOfShoppingList}/products/{idOfProduct}/update")//TODO Think about resolve better path
    @ResponseStatus(HttpStatus.OK)
    public String updateProduct(@PathVariable("idOfProduct") Long idOfProduct, @RequestParam(value = "product", required = false) String name) {
        if (!name.isBlank())
            return "Funciona";
        //TODO
        return "Nao funcionou";
    }
}