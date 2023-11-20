package vendingmachine.utils;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import vendingmachine.view.OutputView;

public class ExceptionHandler {
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final int MAX_RECUR_DEPTH = 10;

    public static <T> T input(Supplier<T> supplier, int depth) {
        if (depth >= MAX_RECUR_DEPTH) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 입력 재시도 최대 가능한 %d회를 초과하였습니다.", MAX_RECUR_DEPTH));
        }
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
            return input(supplier, depth + 1);
        }
    }

    public static <T, R> R convert(Function<T, R> function, T inputString) {
        try {
            return function.apply(inputString);
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
            return null;
        }
    }

    private static void printExceptionMessage(final IllegalArgumentException e) {
        OutputView.printExceptionMessage(String.format("%s %s", ERROR_PREFIX, e.getMessage()));
    }

}