package vendingmachine.util;

public enum Message {
    CHANGE_MESSAGE("잔돈\n"),
    CHANGE_AMOUNT_PREFIX("원 - "),
    CHANGE_AMOUNT_SUFFIX("개\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
