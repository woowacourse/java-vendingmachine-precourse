package vendingmachine.exception;

import java.util.function.Supplier;
import vendingmachine.view.OutputView;

public class RetryHandler {
    private final OutputView outputView = new OutputView();

    public <T> T getOrRetry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            } finally {
                outputView.newLine();
            }
        }
    }

    public void runOrRetry(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            } finally {
                outputView.newLine();
            }
        }
    }
}
