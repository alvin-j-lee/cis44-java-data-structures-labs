import java.util.ArrayList;
import java.util.List;

public class GeneralTreeNode {
    String name; // Employee name or department title
    GeneralTreeNode parent;
    List<GeneralTreeNode> children;

    public GeneralTreeNode(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    // Method to add a child to this node
    public void addChild(GeneralTreeNode child) {
        child.parent = this;
        this.children.add(child);
    }

    /**
     * Preorder Traversal
     * Visit Parent → Children
     */
    public void traversePreorder() {
        // 1. Visit this node
        System.out.println(this.name);

        // 2. Visit all children recursively
        for (GeneralTreeNode child : children) {
            child.traversePreorder();
        }
    }

    /**
     * Postorder Traversal
     * Visit Children → Parent
     */
    public void traversePostorder() {
        // 1. Visit all children first
        for (GeneralTreeNode child : children) {
            child.traversePostorder();
        }

        // 2. Visit this node
        System.out.println(this.name);
    }
}