package com.bootcamp.project.service;

import com.bootcamp.project.dto.ProductDTO;
import com.bootcamp.project.dto.ShoppingListDTO;
import com.bootcamp.project.exception.ProjectException;
import com.bootcamp.project.mappers.ProductMapper;
import com.bootcamp.project.mappers.ShoppingListMapper;
import com.bootcamp.project.model.*;
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
    // Services
    private final ProductService prodService;

    public ShoppingList getShoppingList(Long id){
        return shoppingListRepository.getShoppingListByTodoListID(id).get();
    }
    public ShoppingList newShoppingList(User user, ShoppingList shoppingList) {
        shoppingList.setUser(user);
        return shoppingListRepository.save(shoppingList);
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
    /** Function that deletes a ShoppingList by ID and only if the list is deactivated */
    public void deleteShoppingLists(User user){
        List<ShoppingList> shopLists = shoppingListRepository.findShoppingListsByUser(user);
        if (!shopLists.isEmpty())
            shoppingListRepository.deleteAll(shopLists);
/*        if (!shopLists.isEmpty())
            for(ShoppingList sh : shopLists)
                shoppingListRepository.delete(sh);
*/
    }
}