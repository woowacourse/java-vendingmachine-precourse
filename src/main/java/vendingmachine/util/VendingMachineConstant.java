package vendingmachine.util;

public class VendingMachineConstant {
    public static final String INPUT_VENDING_MACHINE_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String INPUT_PRODUCT_INFO_MESSAGE = "\n상품명과 가격, 수량을 입력해 주세요.";
    public static final String INPUT_USER_MONEY_MESSAGE = "\n투입 금액을 입력해 주세요.";

    public static final String ERROR_PREFIX_MESSAGE = "[ERROR] ";

    public static final String INVALID_INPUT_NUMBER_MESSAGE = "금액은 숫자여야 합니다.";
    public static final String INVALID_INPUT_POSITIVE_NUMBER_MESSAGE = "금액은 양수만 가능합니다.";
    public static final String INVALID_INPUT_MULTIPLE_OF_TEN_MESSAGE = "자판기 보유 금액의 최소 단위는 10원입니다.";
    public static final String NOT_EXIST_PRODUCT = "존재하지 않는 상품명입니다.";
    public static final String NOT_ENOUGH_MONEY = "금액이 부족합니다.";
    public static final String NOT_ENOUGH_AMOUNT = "상품량이 충분하지 않습니다.";

    public static final String HYPHEN = " - ";
    public static final String UNIT_OF_COIN = "원";
    public static final String UNIT_OF_COUNT = "개";

    public static final String RESULT_VENDING_MACHINE_COIN_MESSAGE = "\n자판기가 보유한 동전";

    public static final String INPUT_MONEY_PREFIX_MESSAGE = "\n투입 금액: ";
    public static final String INPUT_PRODUCT_NAME_MESSAGE = "구매할 상품명을 입력해 주세요.";

    public static final int DECREASE_AMOUNT_VALUE = 1;
    public static final int SOLD_OUT_AMOUNT = 0;
}
