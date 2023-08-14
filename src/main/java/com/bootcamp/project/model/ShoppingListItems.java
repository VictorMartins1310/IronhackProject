package com.bootcamp.project.model;

import jakarta.persistence.*;

@Entity(name = "ShoppingListItems")
@Table(name = "ShoppingListItems")
public class ShoppingListItems {
    @Id
    private Long shoppingItemID; //TODO Changees here (This is only for starting the classes)
    private String Item;
    //@Id
//    @ManyToOne
//    @JoinColumn(referencedColumnName = "shoppingListID", name = "ShoppingList")
//    private ShoppingList shoppingList;
    //@Id
//    @ManyToOne
//    @JoinColumn(referencedColumnName = "itemID", name = "item")
//    private Item item;
}
