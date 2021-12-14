package vendingmachine.util.validator;

import static vendingmachine.util.validator.Validator.acceptThrow;

public class CommonValidator {
    public static void isNull(String userInput, ThrowIllegalSupplier validator) {
        if (userInput == null) {
            acceptThrow(() -> validator.get());
        }
    }

    public static void isBlank(String userInput, ThrowIllegalSupplier validator) {
        if (userInput.isEmpty()) {
            acceptThrow(() -> validator.get());
        }
    }
}
