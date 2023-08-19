package com.bootcamp.project.repos;

import com.bootcamp.project.model.Product;
import com.bootcamp.project.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
    ShoppingList getShoppingListByTodoListID(Long id);
}