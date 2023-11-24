package vendingmachine.constants;

public enum Message {
    ASK_MACHINE_OWN("자판기가 보유하고 있는 금액을 입력해 주세요."),
    COIN_STATUS("자판기가 보유한 동전%n"),
    EACH_COIN("%d원 - %d개%n"),
    ASK_PRODUCT_INFO("상품명과 가격, 수량을 입력해 주세요."),
    ASK_INPUT_AMOUNT("투입 금액을 입력해 주세요."),
    MONEY_STATUS("투입 금액: %d원"),
    ASK_BUY_PRODUCT_NAME("구매할 상품명을 입력해 주세요."),
    CHANGE_STATUS_HEADER("잔돈%n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
