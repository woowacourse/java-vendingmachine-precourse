package validator;

public class InputNumberValidator {
    public static int validateInput(String userInput) {
        int inputValue = isNumber(userInput);
        isPositiveNumber(inputValue);
        return inputValue;
    }

    public static int isNumber(String userInput) {

    }
}
