package com.bootcamp.project.service;

import com.bootcamp.project.repos.ShoppingListItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingListItemService {
    private final ShoppingListItemsRepository shoppingListItemsRepository;
}
