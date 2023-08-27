package com.bootcamp.project.service;

import com.bootcamp.project.dto.DTOProduct;
import com.bootcamp.project.dto.DTOShoppingList;
import com.bootcamp.project.dto.DTOUser;
import com.bootcamp.project.exception.ProjectException;
import com.bootcamp.project.mappers.ShoppingListMapper;
import com.bootcamp.project.mappers.ShoppingListMapperImpl;
import com.bootcamp.project.model.*;
import com.bootcamp.project.repos.ShoppingListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShoppingListService {
    // Repositories
    private final ShoppingListRepository shoppingListRepository;
    // Services
    private final ProductService prodService;
    private final ToDoListService todoService;
    private final UserService userService;
    //Mappers
    private final ShoppingListMapper shoppingListMapper;


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
    public DTOShoppingList newShoppingList(UUID uuid, DTOShoppingList shoppingList) {
        User user = userService.getUser(uuid);
        ShoppingList shopList2 = shoppingListMapper.toEntity(shoppingList);
        shopList2.setUser(user);
/*        ShoppingList shopList = new ShoppingList(
                shoppingList.getTodoListName(),
                user,
                shoppingList.getMarketName());*/
        shoppingListRepository.save(shopList2);
        return shoppingListMapper.toDto(shopList2);
    }
    public List<DTOProduct> getAllProductsOfShoppingList(Long shoppingID){
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
    /** Function that deletes a ShoppingList by ID and only if the list is deactivated */
    public boolean deleteShoppingList(Long id){
        var shop = shoppingListRepository.findById(id);
        if (shop.isPresent()){
            if (!shop.get().getActive()) {
                for (Product product : shop.get().getProducts())
                    shop.get().getProducts().remove(product);
                shoppingListRepository.delete(shop.get());
            }
            else return false;
        }else return false;
        return true;
    }
    public void deactivateAutomatic(){

    }
}