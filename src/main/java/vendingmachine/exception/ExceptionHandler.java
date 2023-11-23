package vendingmachine.exception;
import static vendingmachine.exception.ErrorCode.INVALID_INPUT;

import java.util.function.Supplier;
import vendingmachine.view.output.ErrorOutputWriter;

public class ExceptionHandler {
    private ExceptionHandler() {
    }

    public static <T> T retryOnBusinessException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (BusinessException exception) {
                ErrorOutputWriter.println(exception.getMessage());
            }
        }
    }

    public static <T> T tryOnParseIntException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NumberFormatException exception) {
            throw BusinessException.of(INVALID_INPUT, exception);
        }
    }
}