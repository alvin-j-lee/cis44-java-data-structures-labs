/*
 * LinkedQueue is a queue implementation that uses a singly
 * linked list to store elements. Items are added to the rear
 * of the queue and removed from the front.
 */

class LinkedQueue implements Queue {

    private class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    // Constructs an empty LinkedQueue.Initially both front and rear are null
    // because the queue contains no elements
    public LinkedQueue() {
        front = null;
        rear = null;
    }

    // Adds an item to the rear of the queue.

    @Override
    public void enqueue(Object item) {
        Node newNode = new Node(item);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Removes and returns the item at the front of the queue.
    @Override
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }

        Object data = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return data;
    }

    // Returns true if the queue has no elements.
    @Override
    public boolean isEmpty() {
        return front == null;
    }
}