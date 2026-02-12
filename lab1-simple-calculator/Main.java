public class Main {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        Calculator calculator = new Calculator(outputHandler);

        outputHandler.displayMessage("Welcome to the Console Calculator!");
        outputHandler.displayMessage("Enter numbers and operators (+, -, *, /, =). Type 'exit' to quit.");

        while (true) {
            String userInput = inputHandler.readInput();

            if (inputHandler.isExit(userInput)) {
                outputHandler.displayMessage("Calculator terminated.");
                break;
            }

            if (inputHandler.isNumber(userInput)) {
                double number = Double.parseDouble(userInput);
                calculator.performOperation(number, "");
            } else if (inputHandler.isOperator(userInput)) {
                calculator.performOperation(0, userInput);
            } else {
                outputHandler.displayError("Invalid input. Enter a number or operator (+, -, *, /, =).");
            }
        }

        inputHandler.close();
    }
}