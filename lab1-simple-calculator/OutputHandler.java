/*
    This class is meant for handling all messages to the user after the start of the program.
 */

public class OutputHandler {

    public void displayScreen(double value) {
        System.out.println("Screen: " + value);
    }

    public void displayError(String message) {
        System.out.println("Error: " + message);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}