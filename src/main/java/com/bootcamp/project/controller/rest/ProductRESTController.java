package com.bootcamp.project.controller.rest;

import com.bootcamp.project.controller.api.ProductAPIController;
import com.bootcamp.project.model.Product;
import com.bootcamp.project.service.ProductService;
import com.bootcamp.project.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "rest")
public class ProductRESTController implements ProductAPIController {
    private final ShoppingListService shopListService;
    @PostMapping(value = route + "/new")
    public Product addProduct(@PathVariable("shopid") Long shopid, @RequestBody Product product){
        shopListService.addProdut2List(shopid, product);
        return product; //TODO Develop?
    }
}
