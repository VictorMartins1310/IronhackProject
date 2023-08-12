package com.bootcamp.project.repos;

import com.bootcamp.project.model.ShoppingListItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListItemsRepository extends JpaRepository<ShoppingListItems, Long> {
}
