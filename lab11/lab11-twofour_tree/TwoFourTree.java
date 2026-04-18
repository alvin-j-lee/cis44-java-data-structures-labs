/**
 * TwoFourTree.java
 * 
 * Implements a 2-4 Tree (multi-way search tree).
 * 
 * Classes:
 * - TwoFourNode: Represents a node containing 1–3 keys and up to 4 children.
 *   Methods:
 *     - isLeaf(): boolean → checks if node is a leaf
 *     - isFull(): boolean → checks if node has 3 keys
 *     - getNextChild(int key): TwoFourNode → returns child to traverse
 *     - insertKey(int key): void → inserts key in sorted order
 * 
 * - TwoFourTree: Represents the tree structure.
 *   Methods:
 *     - insert(int key): void → inserts a key into the tree
 *     - split(TwoFourNode node): void → splits overflowing nodes
 *     - inorder(): void → prints inorder traversal
 *     - inorder(TwoFourNode node): void → recursive helper
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public boolean isFull() {
        return keys.size() == 3;
    }

    public TwoFourNode getNextChild(int key) {
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    public void insertKey(int key) {
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // Descend to leaf
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }

        node.insertKey(key);

        // Handle overflow
        while (node != null && node.keys.size() > 3) {
            split(node);
            node = node.parent;
        }
    }

    private void split(TwoFourNode node) {
        // Keys must be sorted
        Collections.sort(node.keys);

        int midIndex = 2; // middle of 4 keys
        int midKey = node.keys.get(midIndex);

        TwoFourNode left = new TwoFourNode();
        TwoFourNode right = new TwoFourNode();

        // Assign keys
        left.keys.add(node.keys.get(0));
        left.keys.add(node.keys.get(1));
        right.keys.add(node.keys.get(3));

        // Handle children if not leaf
        if (!node.isLeaf()) {
            for (int i = 0; i <= 2; i++) {
                TwoFourNode child = node.children.get(i);
                left.children.add(child);
                child.parent = left;
            }

            for (int i = 3; i < node.children.size(); i++) {
                TwoFourNode child = node.children.get(i);
                right.children.add(child);
                child.parent = right;
            }
        }

        if (node == root) {
            // New root
            root = new TwoFourNode();
            root.keys.add(midKey);
            root.children.add(left);
            root.children.add(right);

            left.parent = root;
            right.parent = root;
        } else {
            TwoFourNode parent = node.parent;

            // Insert middle key into parent
            parent.insertKey(midKey);

            // Replace old child with left & right
            int index = parent.children.indexOf(node);
            parent.children.remove(index);
            parent.children.add(index, left);
            parent.children.add(index + 1, right);

            left.parent = parent;
            right.parent = parent;
        }
    }

    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                if (i < node.children.size()) {
                    inorder(node.children.get(i));
                }
                System.out.print(node.keys.get(i) + " ");
            }
            if (i < node.children.size()) {
                inorder(node.children.get(i));
            }
        }
    }
}