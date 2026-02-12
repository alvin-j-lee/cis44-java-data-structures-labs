/*
    This class is meant to handle all console inputs from the user, including
    the exit command, handling numbers, and handling operators.
 */

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public String readInput() {
        System.out.print("> ");
        return scanner.nextLine().trim();
    }

    public boolean isExit(String input) {
        return input.equalsIgnoreCase("exit");
    }

    public boolean isOperator(String input) {
        return input.equals("+") || input.equals("-") || input.equals("*")
                || input.equals("/") || input.equals("=");
    }

    public boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void close() {
        scanner.close();
    }
}