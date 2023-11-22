package vendingmachine.utils;

import static vendingmachine.exception.ErrorMessage.NOT_NUMERIC_INPUT_AMOUNT;

public class InputAmountValidator {
    public static long safeParseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_INPUT_AMOUNT.getMessage());
        }
    }
}
