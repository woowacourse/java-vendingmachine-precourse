package vendingmachine.util.validator;

import static vendingmachine.util.validator.Validation.acceptThrow;

public class StringValidation {
    public static void isNotInteger(String userInput, StringValidator validator) {
        for(char eachChar : userInput.toCharArray()) {
            validEachCharIsNotInteger(eachChar, validator);
        }
    }

    private static void validEachCharIsNotInteger(char eachChar, StringValidator validator) {
        if(!Character.isDigit(eachChar)) {
            acceptThrow(() -> validator.get());
        }
    }
}
