package vendingmachine.util.validator;

import java.util.function.Supplier;

public interface Validator {
    static IllegalArgumentException acceptThrow(Supplier<IllegalArgumentException> validator) {
        throw validator.get();
    }
}
