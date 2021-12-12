package vendingmachine.utils;

public class ExceptionMessages {

    private static final String ERROR = "[ERROR] ";
    public static final String NOT_NUMBER_EXCEPTION = ERROR + "숫자를 입력하셔야 합니다.";
    public static final String NEGATIVE_NUMBER_EXCEPTION = ERROR + "음수를 입력하시면 안 됩니다.";
    public static final String HAS_ONES_NUMBER_EXCEPTION = ERROR + "1원 단위는 입력하시면 안 됩니다.";
    public static final String UNKNOWN_MERCHANDISE_NAME_EXCEPTION = ERROR + "존재하지 않는 상품명입니다.";
    public static final String SOLD_OUT_EXCEPTION = ERROR + "매진된 상품입니다.";
}
