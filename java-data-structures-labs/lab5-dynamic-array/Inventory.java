/*
 * Inventory.java
 *
 * Represents a player's inventory using an ArrayList to store Item objects.
 * Provides functionality to add items, display current inventory contents,
 * and safely combine two items using an Iterator.
 *
 * The combineItems method demonstrates safe removal of elements
 * during iteration by using iterator.remove() to prevent
 * ConcurrentModificationException.
 *
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {

    private List<Item> items;

    // Constructor
    public Inventory() {
        this.items = new ArrayList<>();
    }

    // Add item
    public void addItem(Item item) {
        items.add(item);
    }

    // Display inventory
    public void display() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory contains:");
            for (Item item : items) {
                System.out.println("- " + item);
            }
        }
        System.out.println();
    }

    // Combine two items safely using Iterator
    public void combineItems(String name1, String name2) {

        boolean found1 = false;
        boolean found2 = false;

        Iterator<Item> iter = items.iterator();

        while (iter.hasNext()) {
            Item current = iter.next();

            if (!found1 && current.getName().equals(name1)) {
                found1 = true;
                iter.remove(); // SAFE removal
            }
            else if (!found2 && current.getName().equals(name2)) {
                found2 = true;
                iter.remove(); // SAFE removal
            }
        }

        if (found1 && found2) {
            System.out.println("Successfully combined " + name1 + " and " + name2 + "!");
            items.add(new Item("Magic Staff"));
        } else {
            System.out.println("Combination failed. Required items not found.");
        }

        System.out.println();
    }
}