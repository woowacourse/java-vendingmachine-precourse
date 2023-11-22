package vendingmachine.exception;

import java.util.function.Supplier;

public interface ExceptionHandler {
    <T> T execute(Supplier<T> action, Class<? extends Exception>... exceptions);
}
