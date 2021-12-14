package vendingmachine.domain.validation;

public class ErrorMessage {
    public static final String ERROR = "[ERROR] ";
    public static final String EMPTY_INPUT = "아무 입력도 없거나 공백만 입력되었습니다.";
    public static final String BALANCE_NOT_NUMBER = "자판기 보유 금액은 음수가 아닌 숫자만 입력되어야 합니다.";
    public static final String BALANCE_RANGE = "자판기 보유 금액은 1원 단위가 존재할 수 없습니다.";
    public static final String ITEM_INPUT_FORM =
            "상품 입력 양식은 [상품명,가격,수량]입니다. 각 상품 사이에는 ; 구분자를 포함해야 하며 상품명에는 ,[]; 문자들을 사용할 수 없습니다.";
    public static final String ITEM_NAME_SPACE_POSITION = "상품명 맨 앞, 뒤에는 공백을 포함할 수 없습니다.";
    public static final String ITEM_NAME_ONLY_SPACE = "상품명이 공백으로만 이루어져 있습니다.";
    public static final String ITEM_NAME_OVERLAP = "중복된 상품명이 존재합니다.";
    public static final String ITEM_PRICE_NOT_NUMBER = "상품 가격은 100 이상의 숫자만 입력되어야 합니다.";
    public static final String ITEM_PRICE_RANGE = "상품 가격은 100원 이상이며 10원으로 나누어 떨어져야 합니다.";
    public static final String ITEM_STOCK_FORM = "상품 수량은 1 이상의 숫자만 입력되어야 합니다.";
    public static final String INSERT_MONEY_FORM = "투입 금액은 0 이상의 숫자여야 하며 10으로 나누어 떨어져야 합니다.";
    public static final String ITEM_NAME_NOT_EXISTS = "자판기에 해당 상품명이 존재하지 않습니다.";
    public static final String ITEM_NOT_IN_STOCK = "해당 상품이 모두 소진되었습니다.";
    public static final String LACK_PURCHASE_MONEY = "투입 금액이 부족합니다.";
}
