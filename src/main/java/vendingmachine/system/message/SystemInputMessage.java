package vendingmachine.system.message;

public enum SystemInputMessage {
    INPUT_HOLDING_MONEY_MESSAGE("자판기가 보유하고 있는 금액을 입력해 주세요."),
    INPUT_PRODUCT_PRICE_STOCK_MESSAGE("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_USER_INSERT_MONEY_MESSAGE("투입 금액을 입력해주세요."),
    INPUT_PRODUCT_NAME_TO_BUY_MESSAGE("구매할 상품명을 입력해주세요.");

    private final String message;

    SystemInputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
