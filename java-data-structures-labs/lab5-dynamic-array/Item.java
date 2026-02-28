/*
 * Item.java
 *
 * Represents a single item in the player's inventory.
 * Each Item object stores the name of the item and
 * provides basic methods to access and display it.
 *
 * This class is used by the Inventory class to manage
 * and combine items safely using an Iterator.
 */

public class Item {

    private String name;

    // Constructor
    public Item(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    // toString method for display
    @Override
    public String toString() {
        return name;
    }
}