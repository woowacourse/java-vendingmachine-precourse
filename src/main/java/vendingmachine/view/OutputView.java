package vendingmachine.view;

public class OutputView {
    private static final String INPUT_AMOUNT_FORMAT = "투입 금액: %d원";
    public void printError(String message) {
        System.out.println(message);
    }

    public void printInputAmount(long amount) {
        printNewLine();
        System.out.printf((INPUT_AMOUNT_FORMAT) + "%n", amount);
    }

    private void printNewLine() {
        System.out.println();
    }
}
