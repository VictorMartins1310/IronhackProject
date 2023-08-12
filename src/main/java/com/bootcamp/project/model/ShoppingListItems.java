package com.bootcamp.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShoppingListItems {
    @Id
    private Long tmpID; //TODO Changees here (This is only for starting the classes)
    //@Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "shoppingListID", name = "ShoppingList")
    private ShoppingList shoppingList;
    //@Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "itemID", name = "item")
    private Item item;
}
