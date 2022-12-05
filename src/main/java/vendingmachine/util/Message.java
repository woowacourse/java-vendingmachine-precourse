package vendingmachine.util;

public enum Message {
    CHANGE_MESSAGE("잔돈\n"),
    CHANGE_AMOUNT_MESSAGE("%d 원 - %개\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }
}
