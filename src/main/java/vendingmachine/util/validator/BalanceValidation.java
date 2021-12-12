package vendingmachine.util.validator;

import static vendingmachine.util.validator.Validation.acceptThrow;

public class BalanceValidation {
    public static void verifyBalanceInput(String userInput, ThrowIllegalSupplier validator) {
        StringValidation.isNotInteger(userInput, validator);
        StringValidation.isOutOfIntegerRange(userInput, validator);

        int userInputAsInt = Integer.parseInt(userInput);

        IntegerValidation.isNegative(userInputAsInt, validator);
        IntegerValidation.isNotMultiplyByTen(userInputAsInt, validator);

    }
}
