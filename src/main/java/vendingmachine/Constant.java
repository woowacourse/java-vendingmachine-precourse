package vendingmachine;

public class Constant {
    public static final String MACHINE_MONEY_INPUT_REQUEST_STRING = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String MACHINE_MONEY_INPUT_IS_NOT_POSITIVE_NUMBER_ERROR_STRING = "[ERROR] 금액은 양의 숫자이어야 합니다.";
    public static final String MACHINE_MONEY_INPUT_IS_NOT_MULTIPLE_OF_10 = "[ERROR] 금액은 10의 배수이어야 합니다.";

    public static final String MACHINE_PRODUCT_INPUT_REQUEST_STRING = "상품명과 가격, 수량을 입력해 주세요.";
    public static final String MACHINE_PRODUCT_INPUT_IS_NOT_RIGHT_FORM_ERROR_STRING = "[ERROR] 상품 정보의 입력 형식을 지켜주세요.";
    public static final String MACHINE_PRODUCT_INPUT_PRICE_QUANTITY_FORM_ERROR_STRING = "[ERROR] 가격과 수량은 양의 숫자이어야 합니다.";
    public static final String MACHINE_PRODUCT_INPUT_PRICE_ERROR_STRING = "[ERROR] 가격은 100원 이상의 10의 배수 이어야 합니다.";

    public static final String USER_MONEY_INPUT_REQUEST_STRING = "투입 금액을 입력해 주세요.";

    public static final String REMAIN_MONEY = "투입 금액: %d원";
    public static final String BUYING_PRODUCT_INPUT_REQUEST_STRING = "구매할 상품명을 입력해 주세요.";
    public static final String MACHINE_DONT_HAVE_PRODUCT_ERROR_STRING = "[ERROR] 존재하지 않는 상품입니다.";

    public static final String COIN500_STRING = "500원 - ";
    public static final String COIN100_STRING = "100원 - ";
    public static final String COIN50_STRING = "50원 - ";
    public static final String COIN10_STRING = "10원 - ";
    public static final String UNIT = "개";
    public static final String NEW_LINE = "\n";
}
