/*
This is the TextEditor class implementation using doubly linked list.

Each node in the list represents a snapshot of the text at a specific point in time.

The editor supports the following methods:
1. add(String newText) to add new text to the current text state. It will erase forward history.
2. undo() to move one step backward in history. It also returns the previous text state.
3. redo() to move one step forward in history. It also returns the next text state.
 */

public class TextEditor {

    private static class Node {
        String textState;
        Node prev;
        Node next;

        public Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    // Constructor method
    public TextEditor() {
        // Initial empty string state.
        Node initialNode = new Node("", null, null);
        this.currentNode = initialNode;
    }

    // Add method that appends a string newText to the current text to make updatedText.
    public void add(String newText) {
        // Erase the redo history if it exists
        if (currentNode.next != null) {
            currentNode.next.prev = null; // disconnect forward nodes
            currentNode.next = null;
        }

        // append new text to current text
        String updatedText = currentNode.textState + newText;

        // create new node
        Node newNode = new Node(updatedText, currentNode, null);
        currentNode.next = newNode;

        // move current pointer
        currentNode = newNode;
    }

    // Undo method that moves the current state one step back in history.
    public String undo() {
        if (currentNode.prev != null) {
            currentNode = currentNode.prev;
            return currentNode.textState;
        } else {
            System.out.println("Nothing to undo.");
            return currentNode.textState;
        }
    }

    // Redo method that moves the current state one step forward in history, if possible.
    public String redo() {
        if (currentNode.next != null) {
            currentNode = currentNode.next;
            return currentNode.textState;
        } else { // Redo history is empty
            System.out.println("Nothing to redo.");
            return currentNode.textState;
        }
    }

    public void printCurrent() {
        System.out.println("Current Text: " + currentNode.textState);
    }
}