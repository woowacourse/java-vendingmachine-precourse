package vendingmachine.util;

public enum ViewMessage {
    INPUT_HOLDING_AMOUNT("자판기가 보유하고 있는 금액을 입력해 주세요."),
    INPUT_MERCHANDISE_INFO("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_AMOUNT("투입 금액을 입력해 주세요."),
    INPUT_MERCHANDISE_NAME("구매할 상품명을 입력해 주세요."),

    OUTPUT_HOLDING_CHANGES("자판기가 보유한 동전"),
    OUTPUT_INPUT_AMOUNT("투입 금액: "),
    OUTPUT_CHANGES("잔돈");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
