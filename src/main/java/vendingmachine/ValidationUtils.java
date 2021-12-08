package vendingmachine;

public class ValidationUtils {
	private static final String ERROR_NOT_NUMBER = "[ERROR] 금액은 숫자여야 합니다.";
	private static final String ERROR_NOT_MATCH_UNIT_MONEY = "[ERROR] 금액은 10원 단위여야 합니다.";
	private static final String ERROR_NOT_POSITIVE = "[ERROR] 0 이상의 숫자여야 합니다.";
	private static final String ERROR_IS_BLANK = "[ERROR] 빈 문자열 입력입니다.";

	public static boolean validUnitMoney(int money) {
		if (money % 10 != 0) {
			System.out.println(ERROR_NOT_MATCH_UNIT_MONEY);
			return false;
		}
		return true;
	}

	public static boolean validNumberFormat(String num) {
		try {
			Integer.parseInt(num);
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_NOT_NUMBER);
			return false;
		}
		return true;
	}

	public static boolean isPositive(int num) {
		if (num <= 0) {
			System.out.println(ERROR_NOT_POSITIVE);
			return false;
		}
		return true;
	}

	public static boolean isBlank(String testStr) {
		if (testStr.isEmpty()) {
			System.out.println(ERROR_IS_BLANK);
			return true;
		}
		return false;
	}
}
