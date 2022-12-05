package vendingmachine.util;

public enum ErrorMessage {
    CHANGE_INPUT_EXCEPTION("잔돈 입력이 잘못됐습니다."),
    PRODUCT_COUNT_UNDER_ZERO("상품수량은 0보다 커야합니다."),
    PRODUCT_NOT_EXIST("상품이 존재하지 않습니다."),
    PRODUCT_SOLD_OUT("상품이 다 팔렸습니다.");

    private final String message;
    private final String prefix = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
