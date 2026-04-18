/**
 * AVLTree.java
 *
 * This file implements an AVL (self-balancing) Binary Search Tree.
 * The AVL tree maintains balance by ensuring the height difference
 * (balance factor) between left and right subtrees is always -1, 0, or 1.
 *
 * It supports insertion with automatic rebalancing using:
 * - Single rotations (left, right)
 * - Double rotations (left-right, right-left)
 *
 * Classes:
 * - AVLNode: Represents a node in the AVL tree.
 * - AVLTree: Implements the AVL tree structure and operations.
 *
 * Methods:
 *
 * AVLNode(int key)
 *   Constructor for a node.
 *   @param key The integer value stored in the node.
 *
 * int height(AVLNode N)
 *   Returns the height of a node.
 *   @param N The node.
 *   @return Height of the node (0 if null).
 *
 * int max(int a, int b)
 *   Returns the larger of two integers.
 *   @param a First integer
 *   @param b Second integer
 *   @return Maximum value
 *
 * int getBalance(AVLNode N)
 *   Computes balance factor of a node.
 *   @param N The node
 *   @return Height(left subtree) - Height(right subtree)
 *
 * AVLNode rightRotate(AVLNode y)
 *   Performs a right rotation.
 *   @param y Root of unbalanced subtree
 *   @return New root after rotation
 *
 * AVLNode leftRotate(AVLNode x)
 *   Performs a left rotation.
 *   @param x Root of unbalanced subtree
 *   @return New root after rotation
 *
 * AVLNode leftRightRotate(AVLNode z)
 *   Performs a left-right double rotation.
 *   @param z Root of unbalanced subtree
 *   @return New root after rotation
 *
 * AVLNode rightLeftRotate(AVLNode y)
 *   Performs a right-left double rotation.
 *   @param y Root of unbalanced subtree
 *   @return New root after rotation
 *
 * void insert(int key)
 *   Public method to insert a key into the AVL tree.
 *   @param key Value to insert
 *
 * AVLNode insert(AVLNode node, int key)
 *   Recursive helper for insertion and rebalancing.
 *   @param node Current subtree root
 *   @param key Value to insert
 *   @return Updated subtree root
 *
 * void inorder()
 *   Performs inorder traversal (Left, Root, Right).
 *
 * void preorder()
 *   Performs preorder traversal (Root, Left, Right).
 *
 * void postorder()
 *   Performs postorder traversal (Left, Right, Root).
 */

// AVL Node class
class AVLNode {
    int key, height;
    AVLNode left, right;

    // Constructor
    AVLNode(int key) {
        this.key = key;
        this.height = 1; // new node starts at height 1
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {

    AVLNode root;

    // Return height of a node
    int height(AVLNode N) {
        if (N == null) return 0;
        return N.height;
    }

    // Return maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Compute balance factor
    int getBalance(AVLNode N) {
        if (N == null) return 0;
        return height(N.left) - height(N.right);
    }

    // Right rotation
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // rotation
        x.right = y;
        y.left = T2;

        // update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotation
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // rotation
        y.left = x;
        x.right = T2;

        // update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Left-Right rotation
    AVLNode leftRightRotate(AVLNode z) {
        z.left = leftRotate(z.left);
        return rightRotate(z);
    }

    // Right-Left rotation
    AVLNode rightLeftRotate(AVLNode y) {
        y.right = rightRotate(y.right);
        return leftRotate(y);
    }

    // Public insert method
    public void insert(int key) {
        root = insert(root, key);
    }

    // Recursive insertion with rebalancing
    private AVLNode insert(AVLNode node, int key) {

        // 1. Normal BST insertion
        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // no duplicates

        // 2. Update height
        node.height = 1 + max(height(node.left), height(node.right));

        // 3. Get balance factor
        int balance = getBalance(node);

        // 4. Handle rotations

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key)
            return leftRightRotate(node);

        // Right Left Case
        if (balance < -1 && key < node.right.key)
            return rightLeftRotate(node);

        return node;
    }

    // Inorder traversal
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    // Preorder traversal
    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Postorder traversal
    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(AVLNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }
}