/**
 * AVLTreeDriver.java
 *
 * This file contains the main method used to test the AVLTree implementation.
 * It inserts a sequence of values designed to trigger all AVL rotation cases:
 * - Left rotation (Right-Right case)
 * - Right rotation (Left-Left case)
 * - Left-Right rotation
 * - Right-Left rotation
 *
 * After insertion, the program prints:
 * - Inorder traversal (should be sorted)
 * - Preorder traversal
 * - Postorder traversal
 *
 * Methods:
 *
 * public static void main(String[] args)
 *   Entry point of the program.
 *   Creates an AVLTree, inserts test values,
 *   and prints all traversals.
 *
 *   @param args Command-line arguments (not used)
 */

public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Insert values (triggers all rotations)
        tree.insert(10);
        tree.insert(20);
        tree.insert(30); // Left rotation

        tree.insert(5);
        tree.insert(4);  // Right rotation

        tree.insert(8);  // Left-Right rotation

        tree.insert(25); // Right-Left rotation

        // Print traversals
        System.out.print("Inorder: ");
        tree.inorder();

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("Postorder: ");
        tree.postorder();

        /*
        Expected behavior:
        - Inorder should be sorted
        - Preorder/Postorder reflect balanced AVL structure

        Example (may vary slightly depending on rotations):
        Inorder: 4 5 8 10 20 25 30
        */
    }
}