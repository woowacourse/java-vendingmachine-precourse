package vendingmachine.util.validator;

import static vendingmachine.util.validator.Validation.acceptThrow;

public class CommonValidation{
    public static void isNull(String userInput, ThrowIllegalSupplier validator) {
        if(userInput == null) {
            acceptThrow(() -> validator.get());
        }
    }
}
