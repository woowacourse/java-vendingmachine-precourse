package vendingmachine.util;

public enum ConsoleMessage {

    NO_STOCK("해당 상품의 재고가 존재하지 않습니다."),
    NO_BUDGET("투입 금액이 모자랍니다.");

    public static final String BASE_MESSAGE = "[ALERT] %s";
    private final String message;

    ConsoleMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
