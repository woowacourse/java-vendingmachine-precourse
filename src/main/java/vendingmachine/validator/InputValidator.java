package vendingmachine.validator;

import static vendingmachine.error.ErrorCode.NOT_INTEGER;

public class InputValidator {

    public static int isInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
    }
}
