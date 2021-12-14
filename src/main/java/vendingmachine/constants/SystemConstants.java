package vendingmachine.constants;

import vendingmachine.domain.Coin;

public class SystemConstants {

    public static int ZERO_COINS = 0;
    public static int NO_CUSTOMER_MONEY_LEFT = 0;
    public static int NO_TOTAL_MONEY_LEFT = 0;
    public static int NO_MERCHANDISE_LEFT = 0;

    public static int NAME_IDX = 0;
    public static int PRICE_IDX = 1;
    public static int NUMBER_IDX = 2;

    public static int MINIMUM_NAME_LENGTH = 0;
    public static int MINIMUM_MONEY_INPUT = 0;
    public static int MINIMUM_COIN_DIGIT = Coin.COIN_10.getAmount();
    public static int MINIMUM_PRICE = 100;
    public static int MERCHANDISE_INFO_TYPE_NUM = 3;

    public static String SEMICOLON = ";";
    public static String COMMA = ",";
    public static String BRACKET_OPEN = "[";
    public static String BRACKET_CLOSE = "]";
}
