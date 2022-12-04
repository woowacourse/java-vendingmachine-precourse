package vendingmachine.utils;

public enum ErrorMessage {
    PRODUCT_AMOUNT_NOT_DIVIDE_10("금액은 10으로 나누어 떨어져야합니다."),
    PRODUCT_AMOUNT_LESS_THAN_0("금액은 0 이상이여야합니다."),
    PRODUCT_AMOUNT_LESS_THAN_100("상품 금액은 100원 이상이여야합니다."),
    NOT_ENOUGH_CASH("해당 상품을 구매하기위한 금액이 부족합니다."),
    NOT_EXIST_PRODUCT("존재하지 않는 상품입니다."),
    COIN_NOT_NUMBER("금액은 숫자여야합니다."),
    CHANGE_OUT_OF_RANGE("자판기가 가질 수 있는 금액은 0 ~ 100,000,000 입니다."),
    PRODUCT_FORMAT_NOT_MATCH("입력형태가 올바르지않습니다.\n" +
            "example : [콜라,1500,20];[사이다,1000,10]"),
    PRODUCT_CANNOT_FOUNT("상품을 찾을 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        final String prefix = "[ERROR] ";
        return prefix + this.message;
    }
}
