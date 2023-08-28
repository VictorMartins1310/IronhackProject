package com.bootcamp.project.controller;

import com.bootcamp.project.dto.DTOProduct;

public interface ProductController {
    String userID = "uuid";
    String shoppingLID = "shoppingid";
    Object addProduct(Long todoID, DTOProduct product);
    Object getAllProductsOfShoppingList(Long id);
}