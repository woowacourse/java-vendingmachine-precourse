package vendingmachine.View;

public class OutputView {
    public static void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
