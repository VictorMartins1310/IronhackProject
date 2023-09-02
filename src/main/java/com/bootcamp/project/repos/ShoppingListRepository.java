package com.bootcamp.project.repos;

import com.bootcamp.project.model.Product;
import com.bootcamp.project.model.ShoppingList;
import com.bootcamp.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
    Optional<ShoppingList> getShoppingListByTodoListID(Long id);
    List<ShoppingList> findShoppingListsByUser(User user);
    void deleteShoppingListsByUser(User user);
    Optional<ShoppingList> findShoppingListByTodoListID(Long ID);
}