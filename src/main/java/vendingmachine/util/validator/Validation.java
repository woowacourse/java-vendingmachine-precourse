package vendingmachine.util.validator;

import java.util.function.Supplier;

public class Validation {

    public static void isNull(String userInput, NullValidator validator) {
        if(userInput == null) {
            acceptThrow(() -> validator.get());
        }
    }

    private static IllegalArgumentException acceptThrow(Supplier<IllegalArgumentException> validator) {
        throw validator.get();
    }
}
