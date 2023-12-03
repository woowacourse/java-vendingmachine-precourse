package vendingmachine.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExceptionHandler {
    public static <T> T repeat(Supplier<T> supplier, Consumer<Exception> consumer) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                consumer.accept(e);
            }
        }
    }
}
