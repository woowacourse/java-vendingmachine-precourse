package vendingmachine;

import java.util.regex.Pattern;

public class Validater {
	final static String ERROR_NOT_SQUARE_BRACKETS = "[ERROR]을 옳바르게 입력해주세요.";
	final static String ERROR_DIVIDE_TEN = "[ERROR] 금액은 10으로 나눠져야 합니다.";
	final static String ERROR_NOT_ZERO = "[ERROR] 금액은 0보다 커야 합니다.";
	final static String ERROR_NOT_MONEY = "[ERROR] 금액은 숫자여야 합니다.";
	final static String ERROR_NOT_RIGHT = "[ERROR] 옳바른 입력값이 아닙니다.";
	final static String ERROR_NOT_BEVERAGE = "[ERROR] 자판기에 없는 음료입니다.";
	final static int INDEX_PRICE = 1;
	final static int INDEX_COUNT = 2;

	static String errorMassage;

	static String[] beveragesValid(String readString) {
		isBracket(readString);
		readString = readString.replaceAll("\\[", "");
		readString = readString.replaceAll("\\]", "");

		isMatchRegex(readString);

		String[] beverageInfo = readString.split(",");
		isDivideTen(beverageInfo[INDEX_PRICE]);
		isZeroCheck(beverageInfo[INDEX_COUNT]);

		return beverageInfo;
	}

	// [] 유무체크
	public static void isBracket(String readString) {
		if (readString.charAt(0) != '[' || readString.charAt(readString.length() - 1) != ']') {
			errorMassage = ERROR_NOT_SQUARE_BRACKETS;
			throw new IllegalArgumentException(ERROR_NOT_SQUARE_BRACKETS);
		}
	}

	// 상품 입력 체크
	public static void isMatchRegex(String removedString) {
		if (!Pattern.matches("[a-zA-Z0-9가-힣]+,\\d{3,}+,\\d+", removedString)) {
			errorMassage = ERROR_NOT_RIGHT;
			throw new IllegalArgumentException(ERROR_NOT_RIGHT);
		}
	}

	// 10으로 나눠지는지 체크
	public static void isDivideTen(String price) {
		if (!(Integer.parseInt(price) % 10 == 0)) {
			errorMassage = ERROR_DIVIDE_TEN;
			throw new IllegalArgumentException(ERROR_DIVIDE_TEN);
		}
	}

	// 0 보다 큰지 체크
	public static void isZeroCheck(String notZero) {
		if (Integer.parseInt(notZero) <= 0) {
			errorMassage = ERROR_NOT_ZERO;
			throw new IllegalArgumentException(ERROR_NOT_ZERO);
		}
	}

	// 숫자인지 체크
	public static void isNumberCheck(String number) {
		if (!number.chars().allMatch(Character::isDigit)) {
			errorMassage = ERROR_NOT_MONEY;
			throw new IllegalArgumentException(ERROR_NOT_MONEY);
		}
	}

	//
	public static void notInBeverage() {
		errorMassage = ERROR_NOT_BEVERAGE;
		throw new IllegalArgumentException(ERROR_NOT_BEVERAGE);
	}
}
