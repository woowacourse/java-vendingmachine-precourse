package Constants;

public class CommonValues {
    public static final int MINIMUM_COIN_VALUE = 10;
    public static final int MINIMUM_PRODUCT_VALUE = 100;
    public static final String MONEY_REGEX = "^[1-9]{1}[0-9]*0$";
    public static final String PRODUCT_HEAD_REGEX = "(\\[([가-힣]+),([1-9]{1}[0-9]+0),([1-9]{1}[0-9]*)\\])+";
    public static final String PRODUCT_TAIL_REGEX = "(;\\[([가-힣]+),([1-9]{1}[0-9]+0),([1-9]{1}[0-9]*)\\])*";
    public static final String PRODUCT_TOTAL_REGEX = PRODUCT_HEAD_REGEX + PRODUCT_TAIL_REGEX;
    public static final String PURCHASE_REGEX = "^[가-힣]+$";
    public static final int FALSE = -1;

}
