package vendingmachine.util.validator;

import static vendingmachine.util.validator.Validator.acceptThrow;

public class IntegerValidator {

    public static void isNegative(int userInput, ThrowIllegalSupplier validator) {
        if (userInput < 0) {
            acceptThrow(() -> validator.get());
        }
    }

    public static void isNotMultiplyByTen(int userInput, ThrowIllegalSupplier validator) {
        if(userInput%10 != 0) {
            acceptThrow(() -> validator.get());
        }
    }
}
