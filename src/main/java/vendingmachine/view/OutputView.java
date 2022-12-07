package vendingmachine.view;

public class OutputView {

    private enum ConsoleMessage {
        INPUT_BUDGET("구입금액을 입력해 주세요.");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }
    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
