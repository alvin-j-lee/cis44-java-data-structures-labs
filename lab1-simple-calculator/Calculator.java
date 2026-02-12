/*
    This class is meant to handle all
 */
public class Calculator {

    private double currentValue = 0;
    private double storedValue = 0;
    private String operator = "";
    private boolean newInput = true;

    private final OutputHandler output;

    public Calculator(OutputHandler output) {
        this.output = output;
    }

    public void performOperation(double number, String inputOperator) {
        if (inputOperator.isEmpty()) {
            // input is a number
            if (newInput) {
                currentValue = number;
                newInput = false;
            } else {
                currentValue = number;
            }
            output.displayScreen(currentValue);
        } else if (inputOperator.equals("=")) {
            // equals pressed
            if (!operator.isEmpty()) {
                currentValue = calculate(storedValue, currentValue, operator);
            }
            output.displayScreen(currentValue);
            storedValue = currentValue;
            operator = "";
            newInput = true;
        } else {
            // operator pressed (+, -, *, /)
            if (!operator.isEmpty()) {
                currentValue = calculate(storedValue, currentValue, operator);
            }
            operator = inputOperator;
            storedValue = currentValue;
            newInput = true;
            output.displayScreen(currentValue);
        }
    }

    private double calculate(double a, double b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> (b == 0) ? handleDivideByZero(a) : a / b;
            default -> b;
        };
    }

    private double handleDivideByZero(double a) {
        output.displayError("Division by zero!");
        return a;
    }
}
