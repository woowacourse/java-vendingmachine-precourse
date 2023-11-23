package vendingmachine.view.constants;

public enum UserMessage {
    INPUT_USER_AMOUNT("\n투입 금액을 입력해 주세요."),
    INPUT_USER_PRODUCT("구매할 상품명을 입력해 주세요.");
    private final String message;

    UserMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
