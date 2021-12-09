package vendingmachine;

import java.util.regex.Pattern;

public class Constants {
	public static final String ERROR = "[ERROR]";
	public static final String DELIMITER_PRODUCT = ",";
	public static final String DELIMITER_PRODUCTS = ";";
	public static final String[] DELIMITER_PRODUCT_BOXER = {"\\[", "\\]"};

	public static final String MONEY_REGEX = "[1-9]+[0-9]+0";
	public static final String NAME_REGEX = "[가-힣\\w]+";
	public static final String NUMBER_REGEX = "[1-9]+[0-9]*";
	public static final String PRODUCT_REGEX =
		NAME_REGEX + DELIMITER_PRODUCT + MONEY_REGEX + DELIMITER_PRODUCT + NUMBER_REGEX;

	public static final Pattern MONEY_PATTERN = Pattern.compile("^" + MONEY_REGEX + "$");
	public static final Pattern PRODUCT_PATTERN = Pattern.compile(
		"^" + "(" + DELIMITER_PRODUCT_BOXER[0] + PRODUCT_REGEX + DELIMITER_PRODUCT_BOXER[1] + ")"
			+ "(" + DELIMITER_PRODUCTS
			+ DELIMITER_PRODUCT_BOXER[0] + PRODUCT_REGEX + DELIMITER_PRODUCT_BOXER[1] + ")*" + "$");
}
