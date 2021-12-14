package vendingmachine.constant;

public class ErrorMessage {
    public static final String ERROR_SIGN = "[ERROR] ";

    public static final String IS_NOT_INTEGER_ERROR_MESSAGE = ERROR_SIGN + "숫자를 입력해주세요.";
    public static final String NOT_DIVISIBLE_TEN_ERROR_MESSAGE = ERROR_SIGN + "10원 단위로 나눠떨어지지 않습니다.";

    public static final String IS_NOT_POSSIBLE_PRODUCT_PRICE = ERROR_SIGN + "상품은 100원 이상부터 가능합니다.";


}
