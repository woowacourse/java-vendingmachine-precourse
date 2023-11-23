package vendingmachine.view.constants;

public enum UserMessage {
    INPUT_USER_AMOUNT("투입 금액을 입력해 주세요.");

    private final String message;

    UserMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
