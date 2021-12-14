package vendingmachine;

public abstract class Constant {
    public static int MINIMUM_COIN_VALUE = 10;
    public static int ZERO = 0;
    public static int PRODUCT_PRICE_MIN_VALUE = 100;
    public static int PRODUCT_INFO_CNT = 3;
    public static int PRODUCT_NAME_IDX = 0;
    public static int PRODUCT_PRICE_IDX = 1;
    public static int PRODUCT_QUANTITY_IDX = 2;

    public static String NUMBER_REGEX = "^[0-9]*$";
    public static String PRODUCT_DELIMETER = ";";
    public static String PRODUCT_INFO_DELIMETER = ",";
    public static String EXIT_CODE = "반환;";

    public static char INPUT_WRAP_START = '[';
    public static char INPUT_WRAP_END = ']';

}
