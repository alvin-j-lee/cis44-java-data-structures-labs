/*
    This is the DynamicArray class that is our implementation of Java's native ArrayList.

    The DynamicArray has 7 methods of interest:
    1. Constructor method
    2. add() method that adds elements to the end of the list
    3. get() method that returns the element at a specified index
    4. remove() method that removes an element at a specified index, and shifts left.
       We also need to empty the last index of our DynamicArray
    5. size() method returns the number of elements in DynamicArray
    6. resize() method doubles the capacity of the old array and copies it to a new one.
    7. toString() method helps me print DynamicArray for demonstration purposes.
 */

// Import Arrays to build a toString() method for DynamicArray
import java.util.Arrays;

public class DynamicArray<T> {
    private T[] data; //array to store elements
    private int size; //tracks the number of elements
    private static final int INTIAL_CAPACITY = 10; //initial capacity of array

    // Constructor method
    public DynamicArray() {
        data = (T[]) new Object[INTIAL_CAPACITY];
        size = 0;
    }

    // Adds elements to the end of the list, triggering resize() if full.
    public void add(T element){
        if (size == data.length) {
            resize();
        }

        data[size++] = element;
    }

    // Returns the element at an integer index
    public T get(int index){

        // Check that the index is within bounds
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
        return data[index];
    }

    // Removes the element at an integer index.
    public T remove(int index){

        // Check that the index is within bounds.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }

        // Save the removed element so we can return it at the end of the method.
        T removedElement = data[index];

        // Shift elements left
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null; // Empty the last index of our array.
        size--;

        return removedElement;
    }

    // returns the size of our dynamic array
    public int size(){
        return size;
    }

    // This is the resize method that is called when an element is added to the full array.
    private void resize(){

        T[] newData = (T[]) new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // toString() method turns our DynamicArray to string via copying it into an Array and using Arrays.toString().
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(data, 0, size)); // Only copy the filled portion of the array
    }
}
