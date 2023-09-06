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
        return save(shoppingList);
    }

    public ShoppingList updateShoppingList(Long id, String toDoListName, String marketName) {
        if (shoppingListRepository.findShoppingListByTodoListID(id).isEmpty())
            throw new ProjectException("Shopping List " + id + " Not Found");
        ShoppingList shoppingList = shoppingListRepository.findShoppingListByTodoListID(id).get();
        shoppingList.setTodoListName(toDoListName);
        shoppingList.setMarketName(marketName);
        return save(shoppingList);
    }

    public ShoppingList addProduct2List(Long shopID, Product prod) {
        ShoppingList shoppingList = getShoppingList(shopID);
        if (prod.getProductID() == null){
            Product savedProd = prodService.newProduct(prod);
            shoppingList.addProduct(savedProd);
        } else {
            // This was created for DataLoader, but gaves me a Lazy Exception, so it works but can be Deleted
            shoppingList.addProduct(prod);
        }
        return save(shoppingList);
    }

    public ShoppingList save(ShoppingList shop){
        return shoppingListRepository.save(shop);
    }

    public void deleteShoppingLists(User user) {
        List<ShoppingList> shopLists = shoppingListRepository.findShoppingListsByUser(user);
        if (!shopLists.isEmpty())
            shoppingListRepository.deleteAll(shopLists);
    }

    public void deleteShoppingLists(Long id) {
        Optional<ShoppingList> shoppingList = shoppingListRepository.findById(id);
        if (shoppingList.isPresent() )
            shoppingListRepository.delete(shoppingList.get());
    }
}