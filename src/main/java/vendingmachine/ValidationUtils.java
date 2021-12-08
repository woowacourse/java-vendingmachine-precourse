package vendingmachine;

public class ValidationUtils {
	private static final String ERROR_NOT_NUMBER = "[ERROR] 금액은 숫자여야 합니다.";
	private static final String ERROR_NOT_MATCH_UNIT_MONEY = "[ERROR] 금액은 10원 단위여야 합니다.";

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
}
