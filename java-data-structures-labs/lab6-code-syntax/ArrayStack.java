// Array-based stack implementation
class ArrayStack<E> implements Stack<E> {

    private E[] data;
    private int top;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
        top = 0;
    }

    @Override
    public void push(E element) {
        data[top++] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        E value = data[--top];
        data[top] = null; // helps garbage collection
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return data[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }
}