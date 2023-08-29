package com.bootcamp.project.controller;

import com.bootcamp.project.dto.ProductDTO;

public interface ProductController {
    String userID = "uuid";
    Object addProduct(Long todoID, ProductDTO product);
    Object getAllProductsOfShoppingList(Long id);
    Object boughtProduct(Long idOfProduct, int qty);
    Object updateProduct(Long idOfProduct);
}