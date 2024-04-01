package com.bootcamp.project.controller.abstracts;

import com.bootcamp.project.mappers.ProductMapper;
import com.bootcamp.project.mappers.TodoListMapper;
import com.bootcamp.project.service.ProductService;
import com.bootcamp.project.service.ShoppingListService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ProductController implements com.bootcamp.project.controller.ProductController {
    protected final ShoppingListService shoppingService;
    protected final ProductService productService;

    protected final TodoListMapper shoppingLMapper;
    protected final ProductMapper productMapper;
}
