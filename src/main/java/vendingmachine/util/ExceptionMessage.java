package vendingmachine.util;

public enum ExceptionMessage {

    INVALID_NOT_NUMERIC("자연수만 입력 가능합니다."),
    INVALID_OUT_OF_INT_RANGE("입력 범위를 초과하였습니다."),
    INVALID_UNIT("10원으로 나누어 떨어지는 수를 입력해 주세요."),
    INVALID_COIN_AMOUNT("올바른 금액을 입력해 주세요."),
    INVALID_PRODUCTS_INFO_SIZE("1개 이상의 상품을 입력해 주세요."),
    INVALID_PRODUCT_PRICE_RANGE("상품 가격은 100원 이상만 가능합니다."),
    INVALID_PRODUCT_INFO("상품명, 가격, 수량을 쉼표로 구분해서 입력해 주세요."),
    INVALID_NO_SUCH_PRODUCT("해당하는 상품이 존재하지 않습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}