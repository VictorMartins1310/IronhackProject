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

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(name = "shoppinglist", value = "todolist/shoppinglist")
public class ShoppingListControllerImpl implements ShoppingListController{
    private final ShoppingListService shoppingLService;
    private final UserService userService;
    private final ShoppingListMapper shoppingLMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingListDTO newShoppingList(@RequestBody ShoppingListDTO newShoppingData){
        User loggedUser = userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return shoppingLMapper.toDto(shoppingLService.newShoppingList(loggedUser, newShoppingData.getMarketName()));
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ShoppingListDTO> showShoppingLists(){
        User loggedUser = userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        List<ShoppingListDTO> shoppingListsDTO = new ArrayList<>();
        for (ShoppingList shopL : shoppingLService.getShoppingLists(loggedUser))
            shoppingListsDTO.add(shoppingLMapper.toDto(shopL));
        return shoppingListsDTO;
    }
    @GetMapping(value = "/{shoppingLID}")
    @ResponseStatus(HttpStatus.OK)
    public ShoppingListDTO showShoppingList(@PathVariable("shoppingLID") Long id){
        return shoppingLMapper.toDto(shoppingLService.getShoppingList(id));
    }
    @PatchMapping(value = "/{shoppingLID}")
    @ResponseStatus(HttpStatus.OK)
    public void updateShoppingList(@PathVariable("shoppingLID") Long id, @RequestParam(value = "shplname", required = false) String shplname ,@RequestParam("market") String marketName){
        shoppingLService.updateShoppingList(id, shplname, marketName);
    }
    @DeleteMapping(value = "/{shoppingLID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteShoppingList(@PathVariable("shoppingLID") Long id){
        // TODO
    }

}