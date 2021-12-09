package vendingmachine;

public enum InfoMessage {
    MACHINE_MONEY_INPUT_MESSAGE("자판기가 보유하고 있는 금액을 입력해 주세요."),
    MACHINE_PRODUCT_INPUT_MESSAGE("상품명과 가격, 수량을 입력해 주세요."),
    CUSTOMER_MONEY_INPUT_MESSAGE("투입 금액을 입력해 주세요."),
    CUSTOMER_PURCHASE_INPUT_MESSAGE("구매할 상품명을 입력해 주세요.");

    private String message;

    InfoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
