package vendingmachine.Constant;

public enum Message {
    INITIALIZE_CHANGES("자판기가 보유하고 있는 금액을 입력해 주세요."),
    COUNTS_OF_CHANGES("자판기가 보유한 동전"),
    INITIALIZE_PRODUCTS("상품명과 가격, 수량을 입력해 주세요."),
    PURCHASE_MONEY("투입 금액을 입력해 주세요."),
    PURCHASE_PRODUCT("구매할 상품명을 입력해 주세요."),
    MONEY_AMOUNT_LEFT("투입 금액: %d원\n"),
    RESULT("투입 금액: %d원\n" + "잔돈\n");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
