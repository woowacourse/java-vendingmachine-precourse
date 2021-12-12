package vendingmachine.util.validator;

import java.util.function.Supplier;

public interface NullValidator extends Supplier<IllegalArgumentException> {
}
