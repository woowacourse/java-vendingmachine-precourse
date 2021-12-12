package vendingmachine.util.validator;

import java.util.function.Supplier;

public interface Validation {
    static IllegalArgumentException acceptThrow(Supplier<IllegalArgumentException> validator) {
        throw validator.get();
    }
}
