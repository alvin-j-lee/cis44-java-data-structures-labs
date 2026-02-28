/*
 * Implements a doubly linked list supporting positional operations.
 * Provides methods to add, remove, and navigate elements using positions.
 * Implements Iterable to allow traversal using a for-each loop.
 */

import java.util.Iterator;

public class LinkedPositionalList<E> implements Iterable<E> {

    // Nested Node Class (implements Position)
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        @Override
        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    // Sentinels for the list (header and trailer)
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    // Constructor
    public LinkedPositionalList() {
        header = new Node<>(null, null, null);  // Create header sentinel
        trailer = new Node<>(null, header, null);  // Create trailer sentinel
        header.setNext(trailer);  // Link header to trailer
    }

    // Helper methods for positional operations

    private Position<E> validate(Position<E> p) {
        if (p == null || p == header || p == trailer) {
            throw new IllegalArgumentException("Invalid position.");
        }
        Node<E> node = (Node<E>) p;
        return node;
    }

    private Node<E> node(Position<E> p) {
        return (Node<E>) p;
    }

    //Positional List Methods
    public Position<E> first() {
        return (size == 0) ? null : header.getNext();
    }

    public Position<E> last() {
        return (size == 0) ? null : trailer.getPrev();
    }

    public Position<E> before(Position<E> p) {
        Node<E> node = node(p);
        return node.getPrev() == header ? null : node.getPrev();
    }

    public Position<E> after(Position<E> p) {
        Node<E> node = node(p);
        return node.getNext() == trailer ? null : node.getNext();
    }

    public void addFirst(E e) {
        addBefore(header.getNext(), e);
    }

    public void addLast(E e) {
        addBefore(trailer, e);
    }

    public void addBefore(Position<E> p, E e) {
        Node<E> nextNode = node(p);
        Node<E> prevNode = nextNode.getPrev();
        Node<E> newNode = new Node<>(e, prevNode, nextNode);
        prevNode.setNext(newNode);
        nextNode.setPrev(newNode);
        size++;
    }

    public void addAfter(Position<E> p, E e) {
        Node<E> prevNode = node(p);
        Node<E> nextNode = prevNode.getNext();
        Node<E> newNode = new Node<>(e, prevNode, nextNode);
        prevNode.setNext(newNode);
        nextNode.setPrev(newNode);
        size++;
    }

    public void set(Position<E> p, E e) {
        Node<E> node = node(p);
        node.element = e;
    }

    public void remove(Position<E> p) {
        Node<E> node = node(p);
        Node<E> prevNode = node.getPrev();
        Node<E> nextNode = node.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        size--;
    }

    // --- Nested Iterator Class ---
    private class ElementIterator implements Iterator<E> {
        private Position<E> cursor = first();

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            E element = cursor.getElement();
            cursor = after(cursor);  // Move cursor to the next element
            return element;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }
}
