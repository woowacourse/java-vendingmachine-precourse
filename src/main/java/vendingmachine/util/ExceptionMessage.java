package vendingmachine.util;

public enum ExceptionMessage {

    INVALID_NOT_NUMERIC("자연수만 입력 가능합니다."),
    INVALID_OUT_OF_INT_RANGE("입력 범위를 초과하였습니다."),
    INVALID_UNIT("10원으로 나누어 떨어지는 수를 입력해 주세요."),
    INVALID_COIN_AMOUNT("올바른 금액을 입력해 주세요."),
    INVALID_PRODUCTS_INFO_SIZE("1개 이상의 상품을 입력해 주세요.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}