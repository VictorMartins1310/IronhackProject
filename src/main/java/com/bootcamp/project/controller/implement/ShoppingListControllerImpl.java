package com.bootcamp.project.controller.implement;

import com.bootcamp.project.dto.ShoppingListDTO;
import com.bootcamp.project.dto.ShoppingListProductsDTO;
import com.bootcamp.project.mappers.TodoListMapper;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.service.ShoppingListService;
import com.bootcamp.project.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "shoppinglist", value = "todolist/shoppinglist")
public class ShoppingListControllerImpl extends com.bootcamp.project.controller.abstracts.ShoppingListController{
    public ShoppingListControllerImpl(ShoppingListService shoppingLService, TodoListMapper shoppingLMapper, UserService userService) {
        super(shoppingLService, shoppingLMapper, userService);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingListDTO newShoppingList(@RequestBody ShoppingListDTO newShoppingData){
        return shoppingLMapper.toDto(shoppingLService.newShoppingList(userService.getAutenticatedUser(), newShoppingData.getMarketName()));
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ShoppingListDTO> showShoppingLists(){
        return shoppingLMapper.toShoppingListDtos(shoppingLService.getShoppingLists(userService.getAutenticatedUser()));
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
    public void deleteShoppingList(@PathVariable("shoppingLID") Long id){
        shoppingLService.deleteShoppingList(id);
    }
}
