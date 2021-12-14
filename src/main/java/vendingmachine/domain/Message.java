package vendingmachine.domain;

public class Message {
    public static final String REQUEST_INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해주세요.";
    public static final String INFORM_COIN_COUNT = "\n자판기가 보유한 동전";
    public static final String REQUEST_PRODUCT_MESSAGE = "상품명과 가격, 수량을 입력해주세요.";
    public static final String REQUEST_CHANGE_MESSAGE = "\n투입 금액을 입력해 주세요.";
    public static final String INFORM_CHANGE_MESSAGE = "잔돈";
    public static String INFORM_CHANGE_AMOUNT_MESSAGE = "\n투입 금액: %d원\n";

    public static final String ERROR_SAME_PRODUCT_NAME = "[ERROR] 동일한 상품명이 존재합니다.";
    public static final String ERROR_SPACE_PRODUCT_NAME = "[ERROR] 상품명은 공백일 수 없습니다.";
    public static final String ERROR_NOT_NUMBER = "[ERROR] 숫자를 입력해 주세요.";
    public static final String ERROR_NEGATIVE_NUMBER = "[ERROR] 0 이상의 숫자를 입력해 주세요.";
    public static final String ERROR_NOT_DIVISIBLE_BY_TEN = "[ERROR] 금액은 10으로 나누어 떨어지는 값이어야 합니다.";
    public static final String ERROR_NOT_IN_BRACKETS = "[ERROR] 각 상품 정보를 대괄호([, ])로 묶어주세요.";
    public static final String ERROR_PRODUCT_FORMAT = "[ERROR] [상품명,가격,수량] 형식으로 입력해 주세요.";

    public static final String REQUEST_INPUT_PRODUCT_NAME = "구매할 상품명을 입력해 주세요.";
    public static final String ERROR_NOT_SINGLE_PRODUCT = "[ERROR] 자판기에 존재하는 하나의 상품을 입력해 주세요.";
}
