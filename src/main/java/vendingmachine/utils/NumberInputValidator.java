package vendingmachine.utils;

import static vendingmachine.constants.SystemConstants.*;
import static vendingmachine.constants.ExceptionMessages.*;

public class NumberInputValidator {

    public static void validateMoneyInput(String input) {
        int intInput = validateIntType(input);
        validateNotNegativeNumber(intInput);
        validateNotHaveOnesDigit(intInput);
    }

    private static int validateIntType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION);
        }
    }

    private static void validateNotNegativeNumber(int intInput) {
        if (intInput < MINIMUM_MONEY_INPUT) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION);
        }
    }

    static void validateNotHaveOnesDigit(int intInput) {
        if (intInput%MINIMUM_COIN_DIGIT > 0) {
            throw new IllegalArgumentException(HAS_ONES_NUMBER_EXCEPTION);
        }
    }
}
