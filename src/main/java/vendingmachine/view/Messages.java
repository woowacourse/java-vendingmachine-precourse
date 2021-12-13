package vendingmachine.view;

public class Messages {
    public static final String ERROR_NOT_INTEGER = "[ERROR] 입력하신 값은 숫자가 아닙니다.";
    public static final String ERROR_NEGATIVE_NUMBER = "[ERROR] 양수의 값을 입력해주세요.";
    public static final String ERROR_INVALID_BRACKET = "[ERROR] 상품명, 가격, 수량은 괄호로 감싸서 입력해주세요. ([사이다,1000,10])";
    public static final String ERROR_INVALID_PRODUCT_INPUT = "[ERROR] 상품 정보는 상품명, 가격, 수량으로 3가지 정보를 입력해주세요. ([사이다,1000,10])";
    public static final String ERROR_PRODUCT_NAME_BLANK = "[ERROR] 상품명의 시작 부분에 공백이 있습니다.";
    public static final String ERROR_EMPTY_INPUT = "[ERROR] 입력에 빈 값이 존재합니다.";
    public static final String ERROR_PRICE_MINIMUN_STANDARD = "[ERROR] 상품의 가격은 100원 이상이어야 합니다.";
    public static final String ERROR_DIVIDE_BY_TEN = "[ERROR] 가격은 10으로 나누어 떨어져야 합니다.";
    public static final String ERROR_NOT_INVALID_ORDER_NAME = "[ERROR] 존재하지 않는 메뉴입니다.";
    public static final String ERROR_LESS_CHANGE = "[ERROR] 돈이 부족합니다.";
    public static final String ERROR_LESS_QUANTITY = "[ERROR] 해당 상품은 품절입니다.";
}
