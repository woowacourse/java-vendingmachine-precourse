package vendingmachine.view;

public class OutputView {

    public static final String ERROR_PREFIX = "[ERROR] : ";

    public static void printError(IllegalArgumentException error) {
        System.out.println(ERROR_PREFIX + error.getMessage());
    }
}
