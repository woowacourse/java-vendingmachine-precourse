package vendingmachine.util;

public class Message {
    public static final String COIN_NO_SUCH_ERROR = "해당 금액의 동전은 없습니다.";
    public static final String CHOICE_DRINK_NO_SUCH_ERROR = "해당 상품은 자판기에 없습니다.";
    public static final String USER_MONEY_STRING_ERROR = "투입 금액은 숫자여야 합니다.";
    public static final String USER_MONEY_MIN_ERROR = "제품 최소 금액 이상의 값을 투입해주세요.";
    public static final String USER_MONEY_OVER_ERROR = "해당 제품은 보유한 금액으로 살 수 없습니다.";
    public static final String USER_MONEY_UNIT_ERROR = "투입 금액은 10원 단위로 나눠져야 합니다.";
    public static final String MACHINE_MONEY_UNIT_ERROR = "금액은 10원 단위로 나눠져야 합니다.";
    public static final String MACHINE_MONEY_RANGE_ERROR = "금액은 10원 이상이어야 합니다.";
    public static final String MACHINE_MONEY_STRING_ERROR = "금액은 숫자여야 합니다.";
    public static final String EMPTY_ERROR = "상품 정보는 공백이 될 수 없습니다.";
    public static final String NAME_NUMBER_ERROR = "상품명은 숫자가 될 수 없습니다.";
    public static final String DRINK_CONTENT_DUPLICATION_ERROR = "상품명은 중복이 될 수 없습니다.";
    public static final String DRINK_CONTENT_ERROR = "상품명, 가격, 숫자가 모두 포함되어야 합니다.";
    public static final String DRINK_SOLD_OUT_ERROR = "해당 상품은 품절입니다. ";
    public static final String PRICE_STRING_ERROR = "가격은 숫자여야 합니다.";
    public static final String PRICE_MIN_VALUE_ERROR = "가격은 100원 이상이어야 합니다.";
    public static final String PRICE_UNIT_ERROR = "가격은 10원 단위로 나눠져야 합니다.";
    public static final String QUANTITY_STRING_ERROR = "상품 갯수는 숫자여야 합니다.";
    public static final String QUANTITY_MIN_VALUE_ERROR = "상품 갯수는 음수가 될 수 없습니다.";
    public static final String INPUT_MACHINE_MONEY_GUIDE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String COIN_STATUS = "자판기가 보유한 동전";
    public static final String CHANGE_STATUS = "잔돈";
    public static final String USER_MONEY_STATUS = "\n투입 금액:";
    public static final String INPUT_DRINKS_GUIDE = "상품명과 가격, 수량을 입력해 주세요.";
    public static final String INPUT_USER_MONEY_GUIDE = "\n투입 금액을 입력해 주세요.";
    public static final String INPUT_CHOICE_DRINK = "구매할 상품명을 입력해 주세요.";

    private Message() {
    }
}
