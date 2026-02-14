/*
    This main file executes a demonstration of our DynamicArray.

    At a high level, this is my design:

    1. add() 10 random integers into our DynamicArray
    2. Display the DynamicArray with the help of java.util.Arrays
    3. Using get(), print the element at a random index between 0 and size-1
    4. remove() the element at THAT random index, and display the DynamicArray
    5. Allow the user the loop this via console input.
 */

import java.util.Random;
import java.util.Scanner;

public static void main(String[] args) {

// Scanner that allows user to loop the demonstration of the program.
    Scanner scanner = new Scanner(System.in);

    // Create a DynamicArray instance
    DynamicArray<Integer> numbers = new DynamicArray<>();

    // Random object to populate the DynamicArray with random numbers
    Random random = new Random();

    // Start the loop for user interaction
    boolean continueLooping = true;

    while (continueLooping) {
        System.out.println("This program will add 10 random Integer objects per loop.");

        // Loop that adds 10 random numbers to the DynamicArray
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(100);  // Generate a random number between 0 and 99
            numbers.add(randomNumber);
        }

        // Print the array using toString() and print the size
        System.out.println("\nArray: " + numbers.toString());
        System.out.println("Size of the array: " + numbers.size());

        // We'll now pick a random index between 0 and size - 1
        int randomIndex = random.nextInt(numbers.size());

        // Get and print the element at that random index
        System.out.println("The element at index " + randomIndex + " is: " + numbers.get(randomIndex));


        // Remove the element at that random index
        System.out.println("We will now remove the element at that index.");
        int removedElement = numbers.remove(randomIndex);
        System.out.println("Removed element: " + removedElement);

        // Print the array again after removal
        System.out.println("This is the array after we've removed the number:");
        System.out.println("Array: " + numbers.toString());

        // Ask the user if they want to continue
        System.out.print("\nDo you want to continue? (Y/y to continue, anything else to exit): ");
        String userInput = scanner.nextLine().trim();
        if (!userInput.equalsIgnoreCase("Y")) {
            continueLooping = false;
        }
    }

    System.out.println("Exiting program...");
    scanner.close();
}