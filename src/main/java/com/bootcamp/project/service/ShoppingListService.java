package com.bootcamp.project.service;

import com.bootcamp.project.dto.DTOUser;
import com.bootcamp.project.exception.ProjectException;
import com.bootcamp.project.model.Product;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.model.ToDoList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.repos.ShoppingListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShoppingListService {
    // Repositories
    private final ShoppingListRepository shoppingListRepository;
    private final ToDoListService todoService;
    private final ProductService prodService;
    private final UserService userService;

    public ShoppingList getShoppingList(Long id){
        return shoppingListRepository.getShoppingListByTodoListID(id).get();
    }
    public ShoppingList newShoppingList(Long todoID, ShoppingList shoppingList){
        ToDoList todo = todoService.getTodoListByID(todoID);
        ShoppingList shopList = new ShoppingList(
                todo.getTodoListName(),
                todo.getUser(),
                shoppingList.getMarketName());
        return shoppingListRepository.save(shopList);
    }
    public ShoppingList newShoppingList(UUID uuid, ShoppingList shoppingList) {
        User user = userService.getUser(uuid);
        ShoppingList shopList = new ShoppingList(
                shoppingList.getTodoListName(),
                user,
                shoppingList.getMarketName());
        return shoppingListRepository.save(shopList);
    }
    public List<Product> getAllProductsOfShoppingList(Long shoppingID){
        ShoppingList shopList = shoppingListRepository.findById(shoppingID).get();
        return shopList.getProducts();
    }
    public ShoppingList addProdut2List(Long shopID, Product prod){
        ShoppingList todo;
        if (shoppingListRepository.getShoppingListByTodoListID(shopID).isPresent()){
            todo = shoppingListRepository.getShoppingListByTodoListID(shopID).get();
            Product savedProd = prodService.newProduct(prod);
            todo.addProduct(savedProd);
            return shoppingListRepository.save(todo);
        } else
            throw new ProjectException("Cannot find Shopping list");
    }
}