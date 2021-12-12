package vendingmachine.util.validator;

import java.util.function.Supplier;

public interface ThrowIllegalSupplier extends Supplier<IllegalArgumentException> {
}
