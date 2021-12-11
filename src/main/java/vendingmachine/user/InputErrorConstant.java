package vendingmachine.user;

public class InputErrorConstant {
    public static final String EMPTY_SPACE = " ";
    public static final int GOODS_PRICE_LIMIT = 100;
    public static final int GOODS_PRICE_RULE = 10;

    public static final String ERROR_PREFIX = "[ERROR]";
    public static final String ERROR_IS_NOT_NUMBER = ERROR_PREFIX + "금액은 숫자여야 합니다.";
    public static final String ERROR_IS_NOT_POSITIVE = ERROR_PREFIX + "금액은 양수여야 합니다.";
    public static final String ERROR_IS_NULL = ERROR_PREFIX + "금액을 입력하셔야 합니다.";
    public static final String ERROR_HAS_SPACE = ERROR_PREFIX + "금액 입력 중간에 빈칸이 포함될 수 없습니다.";

    public static final String ERROR_IS_NOT_100WON_MORE = ERROR_PREFIX + "상품의 가격은 100원 이상부터 가능합니다.";
    public static final String ERROR_IS_NOT_PRICE_RULE = ERROR_PREFIX + "상품의 가격은 10원으로 나누어 떨어져야 합니다.";

}
