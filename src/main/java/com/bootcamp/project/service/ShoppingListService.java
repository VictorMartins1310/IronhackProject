package com.bootcamp.project.service;

import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.model.ToDoList;
import com.bootcamp.project.repos.ShoppingListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;
    private final ToDoListService todoService;
    public ShoppingList newShoppingList(Long todoID, ShoppingList shoppingList){
        ToDoList todo = todoService.findById(todoID);
        //ShoppingList newShopL = ShoppingList()
        return shoppingListRepository.save(shoppingList);
    }
}