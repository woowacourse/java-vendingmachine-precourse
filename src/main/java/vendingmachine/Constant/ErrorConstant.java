package vendingmachine.Constant;

public class ErrorConstant {
    public static final String ERROR_OCCURRED = "[ERROR] ";
    public static final String WrongHoldingAmount = "자판기가 보유하고 있는 금액은 0 이상이며 10으로 나누어떨어지는 정수여야 합니다.";
    public static final String WrongInputFormat = "입력형식에 맞춰 입력해주세요.";
    public static final String PRODUCT_NAME_MUST_NOT_BE_DUPLICATED = "중복된 이름의 상품은 등록이 불가능합니다.";
    public static final String WRONG_COUNT = "상품의 수량은 0 이상의 정수여야 합니다.";
    public static final String WRONG_COST = "상품의 가격은 10원 이상이며 10으로 나누어떨어지는 정수여야 합니다.";
}
