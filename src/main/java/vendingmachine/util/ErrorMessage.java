package vendingmachine.util;

public class ErrorMessage {
    public static final String ERROR = "[ERROR]";
    public static final String MACHINE_MONEY_UNIT_ERROR = String.format("%s 금액은 10원 단위로 나눠져야 합니다.", ERROR);
    public static final String MACHINE_MONEY_RANGE_ERROR = String.format("%s 금액은 10원 이상이어야 합니다.", ERROR);
    public static final String MACHINE_MONEY_STRING_ERROR = String.format("%s 금액은 숫자여야 합니다.", ERROR);
    public static final String EMPTY_ERROR = String.format("%s 상품 정보는 공백이 될 수 없습니다.", ERROR);
    public static final String NAME_NUMBER_ERROR = String.format("%s 상품명은 숫자가 될 수 없습니다.", ERROR);
    public static final String PRICE_STRING_ERROR = String.format("%s 가격은 숫자여야 합니다.", ERROR);
    public static final String PRICE_MIN_VALUE_ERROR = String.format("%s 가격은 100원 이상이어야 합니다.", ERROR);
    public static final String PRICE_UNIT_ERROR = String.format("%s 가격은 10원 단위로 나눠져야 합니다.", ERROR);
    public static final String QUANTITY_STRING_ERROR = String.format("%s 상품 갯수는 숫자여야 합니다.", ERROR);
    public static final String QUANTITY_MIN_VALUE_ERROR = String.format("%s 상품 갯수는 음수가 될 수 없습니다.", ERROR);

    private ErrorMessage() {
    }
}
