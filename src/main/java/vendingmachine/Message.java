package vendingmachine;

public enum Message {
    INPUT_VENDING_MACHINE_HOLDING_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요."),
    INPUT_PRODUCT("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_AMOUNT("투입 금액을 입력해 주세요."),
    INPUT_PRODUCT_NAME("구매할 상품명을 입력해주세요."),
    VENDING_MACHINE_INFORMATION("자판기가 보유한 동전"),
    CHANGE_MONTY("잔돈");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
