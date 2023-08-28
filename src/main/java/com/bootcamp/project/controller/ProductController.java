package com.bootcamp.project.controller;

import com.bootcamp.project.dto.ProductDTO;

public interface ProductController {
    String userID = "uuid";
    String shoppingLID = "shoppingid";
    Object addProduct(Long todoID, ProductDTO product);
    Object getAllProductsOfShoppingList(Long id);
    void boughtProduct(Long idOfProduct, int qty);
    Object updateProduct();
}