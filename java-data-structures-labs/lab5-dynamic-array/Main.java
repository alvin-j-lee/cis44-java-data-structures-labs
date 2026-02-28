/*
 * Main application to test the program.
 */

public static void main(String[] args) {

    Inventory inventory = new Inventory();

    // Add initial items
    inventory.addItem(new Item("Wood"));
    inventory.addItem(new Item("Crystal"));
    inventory.addItem(new Item("Iron"));

    System.out.println("=== Initial Inventory ===");
    inventory.display();

    // Combine items
    inventory.combineItems("Wood", "Crystal");

    System.out.println("=== Final Inventory ===");
    inventory.display();
}
