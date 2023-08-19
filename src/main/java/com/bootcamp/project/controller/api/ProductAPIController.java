package com.bootcamp.project.controller.api;

import com.bootcamp.project.model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api")
public interface ProductAPIController {
    String route = "todolist/shoppinglist/{shopid}/products";
    @PostMapping(value = route + "/new")
    Object addProduct(@PathVariable("shopid") Long shopid, @RequestBody Product product);
}