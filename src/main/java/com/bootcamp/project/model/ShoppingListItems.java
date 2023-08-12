package com.bootcamp.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
/*** This Table surged from Relation Many to Many
 *
 */
public class ShoppingListItems {
    @Id
    private Long tmpID; //TODO Changees here (This is only for starting the classes)
    @Id @ManyToOne
    private ShoppingList shoppingList;
    @Id @ManyToOne
    private Item item;
}
