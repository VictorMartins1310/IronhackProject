package com.bootcamp.project.controller.implement;

import com.bootcamp.project.controller.ShoppingListController;
import com.bootcamp.project.dto.ShoppingListDTO;
import com.bootcamp.project.dto.ShoppingListProductsDTO;
import com.bootcamp.project.mappers.TodoListMapper;
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

/** This Controller is destined for the Shopping List
* It can Create, Update and Delete a Shopping List
*/
@RequiredArgsConstructor
@RestController
@RequestMapping(name = "shoppinglist", value = "todolist/shoppinglist")
public class ShoppingListControllerImpl implements ShoppingListController{
    private final ShoppingListService shoppingLService;
    private final UserService userService;
    private final TodoListMapper shoppingLMapper;

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
    public ShoppingListProductsDTO showShoppingList(@PathVariable("shoppingLID") Long id){
        return shoppingLMapper.toDTO(shoppingLService.getShoppingList(id));
    }
    @PatchMapping(value = "/{shoppingLID}")
    public ShoppingList updateShoppingList(@PathVariable("shoppingLID") Long id, @RequestParam(value = "todolistname", required = false) String todolistname , @RequestParam("marketname") String marketname){
        return shoppingLService.updateShoppingList(id, todolistname, marketname);
    }
    @DeleteMapping(value = "/{shoppingLID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteShoppingList(@PathVariable("shoppingLID") Long id){
        return shoppingLService.deleteShoppingLists(id);
    }
}
