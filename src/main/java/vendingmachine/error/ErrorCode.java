package vendingmachine.error;

public enum ErrorCode {
    PREFIX("[ERROR] "),
    NOT_INTEGER("입력한 값이 정수가 아닙니다."),
    INVALID_PRODUCT_REQUEST("상품 정보가 유효하지 않습니다."),
    INVALID_INPUT_AMOUNT("투입 금액은 10원 단위여야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + this.message;
    }
}
