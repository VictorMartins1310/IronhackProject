package com.bootcamp.project.controller.abstracts;

import com.bootcamp.project.mappers.TodoListMapper;
import com.bootcamp.project.service.ShoppingListService;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ShoppingListController implements com.bootcamp.project.controller.ShoppingListController{
    protected final ShoppingListService shoppingLService;
    protected final TodoListMapper shoppingLMapper;
    protected final UserService userService;
}