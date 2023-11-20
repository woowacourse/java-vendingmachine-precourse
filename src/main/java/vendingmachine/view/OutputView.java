package vendingmachine.view;

public class OutputView {
    public static void printRequestMachinHoldMoney(){
        System.out.println(OutputViewMessage.REQUEST_MACHINE_HOLD_MONEY);
    }
}

enum OutputViewMessage{
    REQUEST_MACHINE_HOLD_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요.");

    private final String message;
    private OutputViewMessage(final String message) {
        this.message = message;
    }
}