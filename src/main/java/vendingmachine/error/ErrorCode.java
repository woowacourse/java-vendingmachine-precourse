package vendingmachine.error;

public enum ErrorCode {
    PREFIX("[ERROR] "),
    INVALID_PRODUCT_REQUEST("상품 정보가 유효하지 않습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + this.message;
    }
}
