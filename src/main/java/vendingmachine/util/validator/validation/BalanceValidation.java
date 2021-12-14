package vendingmachine.util.validator.validation;

import vendingmachine.util.validator.CommonValidator;
import vendingmachine.util.validator.IntegerValidator;
import vendingmachine.util.validator.StringValidator;

import static vendingmachine.util.validator.error.Error.*;
import static vendingmachine.util.validator.error.Error.FOUND_NULL;

public class BalanceValidation {
    private static int userInputAsInt;

    public static void verifyBalanceInput(String userInput) {
        CommonValidator.isNull(userInput,
                () -> new IllegalArgumentException(FOUND_NULL.getMessage()));
        CommonValidator.isBlank(userInput,
                () -> new IllegalArgumentException(FOUND_BLANK.getMessage()));

        StringValidator.isNotInteger(userInput,
                () -> new IllegalArgumentException(IS_NOT_INTEGER.getMessage()));
        StringValidator.isOutOfIntegerRange(userInput,
                () -> new IllegalArgumentException(OUT_OF_RANGE.getMessage()));

        userInputAsInt = Integer.parseInt(userInput);

        IntegerValidator.isNegative(userInputAsInt,
                () -> new IllegalArgumentException(IS_NEGATIVE_INTEGER.getMessage()));
        IntegerValidator.isNotMultiplyByTen(userInputAsInt,
                () -> new IllegalArgumentException(IS_NOT_MULTIPLY_BY_TEN.getMessage()));

    }
}
