package vendingmachine.exception;

import java.util.function.Supplier;
import vendingmachine.view.io.Printer;

public class RetryExceptionHandler {
    private RetryExceptionHandler(){}

    public static <T> T get(Supplier<T> supplier){
        while(true) {
            try{
                return supplier.get();
            } catch (IllegalArgumentException e){
                Printer.printMessage(e.getMessage());
            } finally {
                Printer.printMessage("");
            }
        }
    }

    public static void run(Runnable runnable){
        while(true) {
            try{
                runnable.run();
                return;
            } catch (IllegalArgumentException e){
                Printer.printMessage(e.getMessage());
            } finally {
                Printer.printMessage("");
            }
        }
    }
}
