package vendingmachine.view.constant;

public enum InputMessage {
    REQUEST_VM_COIN("자판기가 보유하고 있는 금액을 입력해 주세요."),
    REQUEST_VM_PRODUCT("상품명과 가격, 수량을 입력해 주세요."),
    REQUEST_INPUT_AMOUNT("투입 금액을 입력해 주세요."),
    REQUEST_BUY_PRODUCT("구매할 상품명을 입력해 주세요.");
    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
