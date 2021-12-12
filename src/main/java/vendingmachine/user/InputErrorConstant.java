package vendingmachine.user;

public class InputErrorConstant {
    public static final String EMPTY_SPACE = " ";
    public static final int GOODS_PRICE_LIMIT = 100;
    public static final int GOODS_PRICE_RULE = 10;
    public static final String GOODS_DELIMITER = ";";
    public static final String SQUARE_BRACKETS_OPEN = "[";
    public static final String SQUARE_BRACKETS_CLOSE = "]";

    public static final String GOODS = "상품명은 ";
    public static final String PRICE = "가격은 ";
    public static final String QUANTITY = "개수는 ";
    public static final String MONEY = "금액은 ";

    public static final String ERROR_PREFIX = "[ERROR]";
    public static final String ERROR_IS_NOT_NUMBER = "숫자여야 합니다.";
    public static final String ERROR_IS_NOT_POSITIVE = "양수여야 합니다.";
    public static final String ERROR_IS_NULL = "입력하셔야 합니다.";
    public static final String ERROR_HAS_SPACE = "입력 중간에 빈칸이 포함될 수 없습니다.";

    public static final String ERROR_GOODS_IS_NULL = ERROR_PREFIX + "상품명과 가격, 수량을 입력하셔야 합니다.";
    public static final String ERROR_IS_NOT_DELIMITER = ERROR_PREFIX + "상품은 세미콜론(;)으로 구분해야 합니다.";
    public static final String ERROR_IS_NOT_SQUARE_BRACKETS = ERROR_PREFIX + "개별 상품은 대괄호([])로 묶어 구분해야 합니다.";
    public static final String ERROR_IS_NOT_100WON_MORE = ERROR_PREFIX + "상품의 가격은 100원 이상부터 가능합니다.";
    public static final String ERROR_IS_NOT_PRICE_RULE = ERROR_PREFIX + "상품의 가격은 10원으로 나누어 떨어져야 합니다.";

    public static final String ERROR_MONEY_IS_NOT_NUMBER = ERROR_PREFIX + MONEY + ERROR_IS_NOT_NUMBER;
    public static final String ERROR_MONEY_IS_NOT_POSITIVE = ERROR_PREFIX + MONEY + ERROR_IS_NOT_POSITIVE;
    public static final String ERROR_MONEY_IS_NULL = ERROR_PREFIX + MONEY + ERROR_IS_NULL;
    public static final String ERROR_MONEY_HAS_NULL = ERROR_PREFIX + MONEY + ERROR_HAS_SPACE;

    public static final String ERROR_PRICE_IS_NOT_NUMBER = ERROR_PREFIX + PRICE + ERROR_IS_NOT_NUMBER;
    public static final String ERROR_PRICE_IS_NOT_POSITIVE = ERROR_PREFIX + PRICE + ERROR_IS_NOT_POSITIVE;
    public static final String ERROR_PRICE_IS_NULL = ERROR_PREFIX + PRICE + ERROR_IS_NULL;
    public static final String ERROR_PRICE_HAS_NULL = ERROR_PREFIX + PRICE + ERROR_HAS_SPACE;

    public static final String ERROR_QUANTITY_IS_NOT_NUMBER = ERROR_PREFIX + QUANTITY + ERROR_IS_NOT_NUMBER;
    public static final String ERROR_QUANTITY_IS_NOT_POSITIVE = ERROR_PREFIX + QUANTITY + ERROR_IS_NOT_POSITIVE;
    public static final String ERROR_QUANTITY_IS_NULL = ERROR_PREFIX + QUANTITY + ERROR_IS_NULL;
    public static final String ERROR_QUANTITY_HAS_NULL = ERROR_PREFIX + QUANTITY + ERROR_HAS_SPACE;

    public static final String ERROR_GOODS_NAME_IS_NULL = ERROR_PREFIX + GOODS + ERROR_IS_NULL;
    public static final String ERROR_GOODS_NAME_HAS_NULL = ERROR_PREFIX + GOODS + ERROR_HAS_SPACE;
}
