package vendingmachine.utils;

public class Constant {
	public static String ERROR_MESSAGE = "[ERROR] ";
	public static int MINIMUM_COIN = 10;
	public static int PLUS_COIN_ELEMENT = 1;
	public static String DELIMITER_OF_COIN_STORE_STATUS_REPRESENT = " - ";
	public static String DELIMITER_OF_PRODUCT_LIST = ";";
	public static int INDEX_OF_PRODUCT_SUBSTRING = 1;
	public static String DELIMITER_PRODUCT_STRING = ",";
	public static int INDEX_OF_PRODUCT_NAME = 0;
	public static int INDEX_OF_PRODUCT_PRICE = 1;
	public static int INDEX_OF_PRODUCT_QUANTITY = 2;
	public static final String REGEX_OF_PRODUCT_INPUT = "\\[.+,\\d{3,},\\d+]";
}
