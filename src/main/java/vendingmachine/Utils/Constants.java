package vendingmachine.Utils;

import java.util.regex.Pattern;

public class Constants {
	// 단위 상수
	public static final Integer[] COIN_NUMS = {500, 100, 50, 10};
	public static final int MIN_MONEY = 100;
	public static final char MONEY_UNIT = '0';
	public static final String COIN_NAME = "COIN_";

	// 정규식 상수
	public static final String DELIMITER = ",";
	public static final String SEPARATOR = ";";
	public static final String WORD_REGEX = "[가-힣\\w]*";
	public static final String BEVERAGE_REGEX = WORD_REGEX + DELIMITER + WORD_REGEX + DELIMITER + WORD_REGEX;

	// 정규식 패턴 상수
	public static final Pattern BEVERAGES_PATTERN = Pattern.compile(
		"^(\\[" + BEVERAGE_REGEX + "])(" + SEPARATOR + "\\[" + BEVERAGE_REGEX + "])*$");
	public static final Pattern NAME_PATTERN = Pattern.compile("^[가-힣\\w]+$");
	public static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]+[0-9]*$");

	// 오류메세지 관련 상수
	public static final String ERROR = "[ERROR] ";
	public static final String ERROR_NUMBER_PATTERN = ERROR + "숫자 입력은 비지 않은 1 이상의 정수 형식이어야 한다.";
	public static final String ERROR_MONEY_RANGE = ERROR + "입력은 100 이상의 정수여야 한다.";
	public static final String ERROR_MONEY_UNIT = ERROR + "숫자의 끝자리는 0이어야 한다.";
	public static final String ERROR_NAME_STRING = ERROR + "이름은 1자 이상의 문자여야 한다.";
	public static final String ERROR_NAME_IN_NAMES = ERROR + "입력된 이름의 제품이 없다.";
	public static final String ERROR_BEVERAGE_STRING = ERROR + "올바른 형식으로 입력해야 한다.";
	public static final String ERROR_BEVERAGE_DUPLICATED = ERROR + "중복된 제품이 있다.";
	public static final String ERROR_USER_POOR = ERROR + "보유금액 이하 가격의 제품을 선택해야 한다.";
	public static final String ERROR_NO_STOCK = ERROR + "해당 제품의 재고가 없다.";
}
