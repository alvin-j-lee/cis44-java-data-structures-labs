/*
 * A simple Queue interface that defines the basic operations
 * for a queue data structure. A queue follows the FIFO
 * (First-In, First-Out) principle.
 */
interface Queue {
    void enqueue(Object item);
    Object dequeue();
    boolean isEmpty();
}