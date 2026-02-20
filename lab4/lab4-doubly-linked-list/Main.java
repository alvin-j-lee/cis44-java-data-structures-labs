/*
This is the main file that tests our TextEditor implementation.

It allows the user to select from a menu of adding text, undoing text,
redoing text, printing the current text, and exiting the program.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        boolean isRunning = true;

        // Loop to
        while (isRunning) {
            System.out.println("Welcome to Alvin's text editor. Please select from the menu.");
            System.out.println("1. Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Print Current Text");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Add text
                    System.out.print("Enter text to append: ");
                    String newText = scanner.nextLine();
                    editor.add(newText);
                    break;

                case 2: // Undo and go back one state in history
                    editor.undo();
                    break;

                case 3: // Redo and go forward a state in history.
                    editor.redo();
                    break;

                case 4: // Print the current text
                    editor.printCurrent();
                    break;

                case 5: // Exit condition
                    isRunning = false;
                    System.out.println("Exiting editor...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}