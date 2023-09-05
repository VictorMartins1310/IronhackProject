package com.bootcamp.project;

import com.bootcamp.project.model.*;
import com.bootcamp.project.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import static com.bootcamp.project.model.ProductType.*;
@Component
@RequiredArgsConstructor
@Profile("dev")
public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {
    private final UserService userService;
    private final ShoppingListService shoppingListService;
    private final ProductService productService;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        long qtyUsers = userService.qtyUsers();
        if (qtyUsers == 0) {
            userService.addRole("ROLE_ADMIN");
            userService.addRole("ROLE_USER");

            User[] users = {
                    userService.newAdmin("Admin@mail.de", "badPassword"),
                    userService.newUser("User@mail.de", "badPassword")
            };

            ShoppingList[] shoppingList = {
                    shoppingListService.newShoppingList(users[1], "ALDI"),
                    shoppingListService.newShoppingList(users[1], "Penny"),
                    shoppingListService.newShoppingList(users[1], "NETTO")
            };
            Product[] products = {
                    new Product("Coca Cola", "Coca Cola Comp",
                            new BigDecimal("1.23"), 4, Drink),
                    new Product("Bananas", "Chiquitas",
                            new BigDecimal("1.23"), 1, Fruit),
                    new Product("Beer", "Super Bock",
                            new BigDecimal("1.23"), 24, Drink),
                    new Product("Chips", "Pringles",
                            new BigDecimal("2.23"), 5, Other)
            };
            for (Product prod: products) {
                shoppingList[0].addProduct(productService.newProduct(prod));
            }
            shoppingListService.save(shoppingList[0]);

        }
    }
}