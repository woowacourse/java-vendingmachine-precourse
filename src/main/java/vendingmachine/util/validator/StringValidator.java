package vendingmachine.util.validator;

import static vendingmachine.util.validator.Validator.acceptThrow;

public class StringValidator {
    public static void isNotInteger(String userInput, ThrowIllegalSupplier validator) {
        for(char eachChar : userInput.toCharArray()) {
            validEachCharIsNotInteger(eachChar, validator);
        }
    }

    private static void validEachCharIsNotInteger(char eachChar, ThrowIllegalSupplier validator) {
        if(!Character.isDigit(eachChar)) {
            acceptThrow(() -> validator.get());
        }
    }

    public static void isOutOfIntegerRange(String userInput, ThrowIllegalSupplier validator) {
        if (Long.parseLong(userInput) > Integer.MAX_VALUE) {
            acceptThrow(() -> validator.get());
        }
    }
}
