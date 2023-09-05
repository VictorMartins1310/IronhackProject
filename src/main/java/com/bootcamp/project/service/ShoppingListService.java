package com.bootcamp.project.service;

import com.bootcamp.project.exception.ProjectException;
import com.bootcamp.project.model.*;
import com.bootcamp.project.repos.ShoppingListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingListService {
    // Repositories
    private final ShoppingListRepository shoppingListRepository;
    // Services
    private final ProductService prodService;
    public ShoppingList getShoppingList(Long id) {
        if (shoppingListRepository.getShoppingListByTodoListID(id).isEmpty())
            throw new ProjectException("Shopping List " + id + " Not Found");
        return shoppingListRepository.getShoppingListByTodoListID(id).get();
    }

    public List<ShoppingList> getShoppingLists(User user) {
        if (shoppingListRepository.findShoppingListsByUser(user).isEmpty())
            throw new ProjectException("Shopping List Not Found");
        return shoppingListRepository.findShoppingListsByUser(user);
    }

    public ShoppingList newShoppingList(User user, String marketName) {
        ShoppingList shoppingList = new ShoppingList(user, marketName);
        return shoppingListRepository.save(shoppingList);
    }

    public ShoppingList updateShoppingList(Long id, String toDoListName, String marketName) {
        if (shoppingListRepository.findShoppingListByTodoListID(id).isEmpty())
            throw new ProjectException("Shopping List " + id + " Not Found");
        ShoppingList shoppingList = shoppingListRepository.findShoppingListByTodoListID(id).get();
        shoppingList.setTodoListName(toDoListName);
        shoppingList.setMarketName(marketName);
        return shoppingListRepository.save(shoppingList);
    }

    public ShoppingList addProdut2List(Long shopID, Product prod) {
        ShoppingList todo;
        if (shoppingListRepository.getShoppingListByTodoListID(shopID).isPresent()) {
            todo = shoppingListRepository.getShoppingListByTodoListID(shopID).get();
            Product savedProd = prodService.newProduct(prod);
            todo.addProduct(savedProd);
            return shoppingListRepository.save(todo);
        } else
            throw new ProjectException("Cannot find Shopping list");
    }

    public ShoppingList save(ShoppingList shop){
        return shoppingListRepository.save(shop);
    }

    /**
     * Function that deletes a ShoppingList by ID and only if the list is deactivated
     */
    public void deleteShoppingLists(User user) {
        List<ShoppingList> shopLists = shoppingListRepository.findShoppingListsByUser(user);
        if (!shopLists.isEmpty())
            shoppingListRepository.deleteAll(shopLists);
    }

    public Boolean deleteShoppingLists(Long id) {
        Optional<ShoppingList> shoppingList = shoppingListRepository.findById(id);
        if (shoppingList.isPresent())
            shoppingListRepository.delete(shoppingList.get());
        else return false;
        return true;
    }
}