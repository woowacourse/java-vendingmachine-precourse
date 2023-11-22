package vendingmachine.exception;

public enum ErrorCode {
    PREFIX("[ERROR] "),
    NOT_INTEGER("입력한 값이 정수가 아닙니다."),
    INVALID_PRODUCT_REQUEST("상품 요청이 유효하지 않습니다."),
    INVALID_INPUT_MONEY("입력 금액은 10원 단위여야 합니다."),
    INVALID_PRODUCT_FORMAT("입력한 상품 정보의 포맷이 올바르지 않습니다."),
    INVALID_PRODUCT_INFO("입력한 상품 정보가 유효하지 않습니다. 가격 혹은 수량을 다시 확인해주세요.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + this.message;
    }
}
