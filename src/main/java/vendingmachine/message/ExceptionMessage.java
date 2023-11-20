package vendingmachine.message;

public class ExceptionMessage {
    public static final String ERROR_PREFIX = "[ERROR] : ";

    public static final String BLANK = "입력값이 없습니다.";
    public static final String LACK_MONEY = "잔액이 부족합니다.";
    public static final String LACK_QUANTITY = "재고가 부족합니다.";
    public static final String NUMBER_FORMAT = "금액은 0 이상의 숫자여야 합니다.";
    public static final String INVALID_COIN = "존재하지 않는 동전입니다.";
    public static final String INVALID_PRODUCT_PRICE = "상품의 가격은 100원 이상이고 10원 단위여야 합니다.";
    public static final String INVALID_PRODUCT_NAME = "잘못된 상품 입력입니다.";
}
