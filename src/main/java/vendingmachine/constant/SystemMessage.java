package vendingmachine.constant;

public class SystemMessage {
    public static final String PRODUCT_DELIMITER = ";";
    public static final String NAME_PRICE_COUNT_DELIMITER = ",";
    public static final String UNNECESSARY_SPECIAL_CHARACTER_REGEX = "[\\[\\]]";
    public static final String PRODUCT_VALIDATION_REGEX = "\\[.+,\\d+,\\d+\\]";
    public static final String BLANK = "";

    public static final Integer NAME = 0;
    public static final Integer PRICE = 1;
    public static final Integer COUNT = 2;
    public static final Integer ONE_THOUSAND_WON = 1000;
    public static final Integer ONE_HUNDRED_WON = 100;
    public static final Integer TEN_WON = 10;
}
