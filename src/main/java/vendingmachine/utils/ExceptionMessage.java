package vendingmachine.utils;

public class ExceptionMessage {

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String ERROR_PRICE_NOT_NUMBER = "금액은 숫자여야 합니다.";
    public static final String ERROR_PRICE_NOT_DIVIDE_BY_TEN = "금액은 10원으로 나눠져야 합니다.";
    public static final String ERROR_COIN_NOT_FOUND = "존재하지 않는 Coin 입니다.";

    public static final String ERROR_BEVERAGE_FORMAT = "올바르지 않는 상품 입력 포맷입니다.";
    public static final String ERROR_BEVERAGE_COUNT_OVERFLOW = "재고가 충분하지 않습니다.";

    public static final String ERROR_INSERT_MONEY_NOT_ENOUGH = "투입 금액이 부족합니다.";
}
