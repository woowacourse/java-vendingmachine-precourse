package vendingmachine.util.validator;

import static vendingmachine.util.validator.Validation.acceptThrow;

public class CommonValidation{
    public static void isNull(String userInput, ThrowIllegalSupplier validator) {
        if(userInput == null) {
            acceptThrow(() -> validator.get());
        }
    }

    public static void isBlank(String userInput, ThrowIllegalSupplier validator) {
        if(userInput.isEmpty()) {
            acceptThrow(() -> validator.get());
        }
    }
}
