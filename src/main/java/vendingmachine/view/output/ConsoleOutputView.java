package vendingmachine.view.output;

public class ConsoleOutputView implements OutputView {
    private static final String INPUT_MONEY_MESSAGE = "투입 금액: ";
    private static final String MONETARY_UNIT = "원";

    @Override
    public void showRemainingInputMoney(int remainingInputMoney) {
        System.out.println(INPUT_MONEY_MESSAGE + remainingInputMoney + MONETARY_UNIT);
    }
}
