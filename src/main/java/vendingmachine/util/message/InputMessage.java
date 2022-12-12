package vendingmachine.util.message;

public enum InputMessage {

    BALANCE("자판기가 보유하고 있는 금액을 입력해 주세요."),
    PRODUCT_INFO("\n상품명과 가격, 수량을 입력해 주세요."),
    AMOUNT_OF_INPUT("\n투입 금액을 입력해 주세요."),
    BUYING_PRODUCT("구매할 상품명을 입력해 주세요.");

    public final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String fullMessage() {
        return message;
    }

}

