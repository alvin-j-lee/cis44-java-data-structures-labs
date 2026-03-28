public class BinaryTreeNode {
    String value; // Operator or operand
    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(String value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Preorder Traversal (Prefix)
     */
    public void traversePreorder() {
        // 1. Visit node
        System.out.print(this.value + " ");

        // 2. Left subtree
        if (left != null) {
            left.traversePreorder();
        }

        // 3. Right subtree
        if (right != null) {
            right.traversePreorder();
        }
    }

    /**
     * Inorder Traversal (Infix)
     */
    public void traverseInorder() {
        // Optional: add parentheses for clarity
        if (left != null) {
            System.out.print("( ");
            left.traverseInorder();
        }

        // Visit node
        System.out.print(this.value + " ");

        if (right != null) {
            right.traverseInorder();
            System.out.print(") ");
        }
    }

    /**
     * Postorder Traversal (Postfix)
     */
    public void traversePostorder() {
        // Left subtree
        if (left != null) {
            left.traversePostorder();
        }

        // Right subtree
        if (right != null) {
            right.traversePostorder();
        }

        // Visit node
        System.out.print(this.value + " ");
    }
}