package vendingmachine.validator;

import static vendingmachine.utils.ExceptionMessages.*;

public class NumberValidator {

    public static void validateTotalMoneyInput(String input) {
        int intInput = validateTotalMoneyInputType(input);
        validateTotalMoneyNotNegative(intInput);
        validateTotalMoneyNotHaveOnes(intInput);
    }

    private static int validateTotalMoneyInputType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION);
        }
    }

    private static void validateTotalMoneyNotNegative(int intInput) {
        if (intInput < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION);
        }
    }

    private static void validateTotalMoneyNotHaveOnes(int intInput) {
        if (intInput%10 > 0) {
            throw new IllegalArgumentException(HAS_ONES_NUMBER_EXCEPTION);
        }
    }
}
