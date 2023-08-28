package com.bootcamp.project.service;

import com.bootcamp.project.dto.DTOProduct;
import com.bootcamp.project.dto.DTOShoppingList;
import com.bootcamp.project.exception.ProjectException;
import com.bootcamp.project.mappers.ProductMapper;
import com.bootcamp.project.mappers.ShoppingListMapper;
import com.bootcamp.project.mappers.ShoppingListMapperImpl;
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
    private final ToDoListService todoService;
    private final UserService userService;
    //Mappers
    private final ShoppingListMapper shoppingListMapper;
    private final ProductMapper productMapper;


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
        shoppingList.setUser(user);
        return shoppingListRepository.save(shoppingList);
    }
    public DTOShoppingList newShoppingList(UUID uuid, DTOShoppingList shoppingList) {
        User user = userService.getUser(uuid);
        ShoppingList shopList = shoppingListMapper.toEntity(shoppingList);
        shopList.setUser(user);
        shoppingListRepository.save(shopList);
        return shoppingListMapper.toDto(shopList);
    }
    public List<DTOProduct> getAllProductsDTOOfShoppingList(Long shoppingID){
        // TODO change to Dto?
        ShoppingList shopList = shoppingListRepository.findById(shoppingID).get();
        return shopList.getProducts().stream().map(productMapper::toDto).toList();
    }
    public List<Product> getAllProductsOfShoppingList(Long shoppingID){
        // TODO change to Dto?
        ShoppingList shopList = shoppingListRepository.findById(shoppingID).get();
        return shopList.getProducts();
    }
    public DTOShoppingList addProdut2List(Long shopID, DTOProduct prod){
        ShoppingList todo;
        if (shoppingListRepository.getShoppingListByTodoListID(shopID).isPresent()){
            todo = shoppingListRepository.getShoppingListByTodoListID(shopID).get();
            Product savedProd = prodService.newProduct(productMapper.toEntity(prod));
            todo.addProduct(savedProd);
            shoppingListRepository.save(todo);
            return shoppingListMapper.toDto(todo);
        } else
            throw new ProjectException("Cannot find Shopping list");
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