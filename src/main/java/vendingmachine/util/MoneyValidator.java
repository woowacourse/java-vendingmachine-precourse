package vendingmachine.util;

public class MoneyValidator {
	public static int validate(String moneyStr) {
		if(!isNumeric(moneyStr))
			throw new IllegalArgumentException(SystemMessage.ERROR_IS_NOT_INTEGER);

		int result = Integer.parseInt(moneyStr);
		if(!isPositive(result))
			throw new IllegalArgumentException(SystemMessage.ERROR_IS_NOT_POSITIVE);

		return result;
	}

	private static boolean isNumeric(String moneyStr) {
		try {
			Integer.parseInt(moneyStr);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	private static boolean isPositive(int number) {
		return number > 0;
	}
}
