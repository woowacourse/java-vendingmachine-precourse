package vendingmachine.util;

public enum ErrorMessage {
    CHANGE_INPUT_EXCEPTION("잔돈 입력이 잘못됐습니다."),
    PRODUCT_COUNT_UNDER_ZERO("상품수량은 0보다 커야합니다."),
    PRODUCT_NOT_EXIST("상품이 존재하지 않습니다."),
    PRODUCT_SOLD_OUT("상품이 다 팔렸습니다."),
    INPUT_NOT_DIGIT("입력값이 숫자가 아닙니다."),
    PRODUCT_FORMAT_EXCEPTION("상품 포맷에 맞춰 입력해 주세요.");

    private final String message;
    private final String prefix = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
