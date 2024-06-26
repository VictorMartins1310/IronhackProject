package com.bootcamp.project.controller.implement.rest;

import com.bootcamp.project.controller.abstracts.TodoListController;
import com.bootcamp.project.dto.ShoppingListDTO;
import com.bootcamp.project.dto.ShoppingListProductsDTO;
import com.bootcamp.project.mappers.TodoListMapper;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.service.ShoppingListService;
import com.bootcamp.project.service.TaskListService;
import com.bootcamp.project.service.ToDoListService;
import com.bootcamp.project.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "shoppinglist", value = "todolist/shoppinglist")
public class ShoppingListControllerImpl extends TodoListController {
    private final TodoListMapper shoppingLMapper;

    public ShoppingListControllerImpl(ToDoListService toDoListService, TaskListService taskListService, ShoppingListService shoppingLService, UserService userService, TodoListMapper todoListMapper, TodoListMapper shoppingLMapper) {
        super(toDoListService, taskListService, shoppingLService, userService, todoListMapper);
        this.shoppingLMapper = shoppingLMapper;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingListDTO newShoppingList(@RequestBody ShoppingListDTO newShoppingData){
        return shoppingLMapper.toDto(newList(newShoppingData));
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ShoppingListDTO> showLists(){
        return shoppingLMapper.toShoppingListDtos(showShoppingLists());
    }
    @GetMapping(value = "/{shoppingLID}")
    @ResponseStatus(HttpStatus.OK)
    public ShoppingListProductsDTO showList(@PathVariable("shoppingLID") Long id){
        return shoppingLMapper.toDTO(showShoppingList(id));
    }
    @PatchMapping(value = "/{shoppingLID}")
    public ShoppingList update(@PathVariable("shoppingLID") Long id, @RequestParam(value = "todolistname", required = false) String todolistname , @RequestParam("marketname") String marketname){
        return updateShoppingList(id, todolistname, marketname);
    }
    @DeleteMapping(value = "/{shoppingLID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("shoppingLID") Long id){
        deleteShoppingList(id);
    }
}