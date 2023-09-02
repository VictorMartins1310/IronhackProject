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

import java.math.BigDecimal;
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

    // A get Product dont make sense here, it makes sense get All Products but make sense Update a Product

    @GetMapping(value = "/{idOfShoppingList}/products")
    public List<ProductDTO> getAllProductsOfShoppingList(@PathVariable("idOfShoppingList") Long id){
        ShoppingList shpL = shoppingService.getShoppingList(id);
        return productService.getAllProductsOfShoppingList(shpL).stream().map(productMapper::toDto).toList();
    }

    @Override
    @PatchMapping(value = "/{idOfShoppingList}/products/{idOfProduct}/bought/{qty}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean boughtProduct(@PathVariable("idOfProduct") Long idOfProduct, @RequestParam("qty") int qty) {
        productService.productBought(idOfProduct, qty);
        return true;
    }
    @PatchMapping(value = "/{idOfShoppingList}/product/{idOfProduct}/update")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(
            @PathVariable("idOfProduct") Long idOfProduct,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "brand", required = false) String brand,
            @RequestParam(value = "name", required = false) String price
            ) {
        Product product = productService.findProductById(idOfProduct);
        if (!name.isEmpty())
            product.setName(name);
        if (!brand.isEmpty())
            product.setBrand(brand);
        if (!price.isEmpty())
            product.setPrice(new BigDecimal(price));
        return productService.save(product);
    }
}