package vendingmachine.error;

public enum ErrorCode {
    PREFIX("[ERROR] "),
    INVALID_PRODUCT_NAME("존재하지 않는 상품명입니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + this.message;
    }
}
