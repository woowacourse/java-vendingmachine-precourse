package vendingmachine;

import java.util.regex.Pattern;

public class Constants {
	public static final Integer[] COIN_NUMS = {500, 100, 50, 10};

	public static final String DELIMITER_PRODUCT = ",";
	public static final String DELIMITER_PRODUCTS = ";";
	public static final String[] DELIMITER_PRODUCT_BOXER = {"\\[", "\\]"};

	public static final String MONEY_REGEX = "[1-9]+[0-9]+0";
	public static final String NAME_REGEX = "[가-힣\\w]+";
	public static final String NUMBER_REGEX = "[1-9]+[0-9]*";
	public static final String PRODUCT_REGEX =
		NAME_REGEX + DELIMITER_PRODUCT + MONEY_REGEX + DELIMITER_PRODUCT + NUMBER_REGEX;

	public static final Pattern MONEY_PATTERN = Pattern.compile("^" + MONEY_REGEX + "$");
	public static final Pattern NAME_PATTERN = Pattern.compile("^" + NAME_REGEX + "$");
	public static final Pattern PRODUCT_PATTERN = Pattern.compile(
		"^" + "(" + DELIMITER_PRODUCT_BOXER[0] + PRODUCT_REGEX + DELIMITER_PRODUCT_BOXER[1] + ")"
			+ "(" + DELIMITER_PRODUCTS
			+ DELIMITER_PRODUCT_BOXER[0] + PRODUCT_REGEX + DELIMITER_PRODUCT_BOXER[1] + ")*" + "$");

	public static final String ERROR = "[ERROR] ";
	public static final String ERROR_MONEY_PATTERN = ERROR + "입력은 정수여야 한다.";
	public static final String ERROR_MONEY_RANGE = ERROR + "입력은 100 이상의 정수여야 한다.";
	public static final String ERROR_MONEY_UNIT = ERROR + "숫자의 끝자리는 0이어야 한다.";
	public static final String ERROR_NAME_STRING = ERROR + "입력은 문자여야 한다.";
	public static final String ERROR_NAME_IN_NAMES = ERROR + "입력된 이름의 제품이 없다.";
	public static final String ERROR_PRODUCT_STRING = ERROR + "올바른 형식으로 입력해야 한다.";
	public static final String ERROR_PRODUCT_DUPLICATED = ERROR + "중복된 제품이 있다.";
	public static final String ERROR_USER_POOR = ERROR + "보유금액 이하 가격의 제품을 선택해야 한다.";
	public static final String ERROR_NO_STOCK = ERROR + "해당 제품의 재고가 없다.";

	public static final int MIN_MONEY = 100;

	public static final char MONEY_UNIT = '0';
	public static final String COIN_NAME = "COIN_";

	public static final String PRINT_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String PRINT_MACHINE_PRODUCTS = "상품명과 가격, 수량을 입력해 주세요.";
	public static final String PRINT_USER_MONEY = "투입 금액을 입력해 주세요.";
	public static final String PRINT_BUY_PRODUCT = "구매할 상품명을 입력해 주세요.";
	public static final String PRINT_MACHINE_COIN = "자판기가 보유한 동전";
	public static final String PRINT_CHANGE = "잔돈";

	public static final String PRINT_COIN_SETTING = "%s원 - %d개%n";
	public static final String PRINT_USER_MONEY_SETTING = "투입 금액: %d원%n";
}
