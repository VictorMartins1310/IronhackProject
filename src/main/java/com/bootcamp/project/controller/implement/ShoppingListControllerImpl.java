package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.ShoppingListController;
import com.bootcamp.project.dto.ShoppingListDTO;
import com.bootcamp.project.mappers.ShoppingListMapper;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.model.User;
import com.bootcamp.project.service.ShoppingListService;
import com.bootcamp.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "shoppinglist", value = "todolist/shoppinglist")
public class ShoppingListControllerImpl implements ShoppingListController{
    private final ShoppingListService shoppingLService;
    private final UserService userService;
    private final ShoppingListMapper shoppingLMapper;
    private final User user = userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    @PostMapping(value = "/user/{userID}")
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingListDTO newShoppingList(@PathVariable("userID") UUID uuid, @RequestBody ShoppingListDTO newShoppingData){
        ShoppingList shopList2save = shoppingLMapper.toEntity(newShoppingData);
        return shoppingLMapper.toDto(shoppingLService.newShoppingList(user, shopList2save));
    }
    @GetMapping(value = "/{shoppingLID}")
    @ResponseStatus(HttpStatus.OK)
    public ShoppingListDTO showShoppingList(@PathVariable("shoppingLID") Long id){
        return shoppingLMapper.toDto(shoppingLService.getShoppingList(id));
    }
    @PatchMapping(value = "/{shoppingLID}")
    @ResponseStatus(HttpStatus.OK)
    public void updateShoppingList(@PathVariable("shoppingLID") Long id){
        // TODO
    }
    @DeleteMapping(value = "/{shoppingLID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteShoppingList(@PathVariable("shoppingLID") Long id){
        // TODO
    }

}