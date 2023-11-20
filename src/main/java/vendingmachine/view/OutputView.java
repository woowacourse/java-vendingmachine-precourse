package vendingmachine.view;

public class OutputView {
    public static void printRequestMachinHoldMoney(){
        System.out.println(OutputViewMessage.REQUEST_MACHINE_HOLD_MONEY.getMessage());
    }
    public static void printRequestProducts(){
        System.out.println(OutputViewMessage.REQUEST_MACHINE_HOLD_MONEY.getMessage());
    }
    public static void printRequestInputAmount() {
        System.out.println(OutputViewMessage.REQUEST_INPUT_AMOUNT.getMessage());
    }
    public static void printRemainAmount(int inputAmount) {
        System.out.printf(OutputViewMessage.REQUEST_INPUT_AMOUNT.getMessage(), inputAmount);
    }

    public static void printRequestWanted() {
        //TODO : 기능 구현
    }

    public static void printExceptionMessage(final String error) {
        System.out.println(error);
    }
}

enum OutputViewMessage{
    REQUEST_MACHINE_HOLD_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요."),
    REQUEST_PRODUCTS("상품명과 가격, 수량을 입력해 주세요."),
    REQUEST_INPUT_AMOUNT("투입 금액을 입력해 주세요."),
    REQUEST_WANTED("구매할 상품명을 입력해 주세요."),
    REMAIN_AMOUNT("투입 금액: %d원\n");

    private final String message;
    private OutputViewMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}