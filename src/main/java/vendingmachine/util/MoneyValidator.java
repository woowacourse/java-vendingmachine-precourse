package vendingmachine.util;

public class MoneyValidator {
	public static int validate(String moneyStr) {
		if(!isNumeric(moneyStr))
			throw new IllegalArgumentException(SystemMessage.ERROR_IS_NOT_INTEGER);

		int result = Integer.parseInt(moneyStr);
		if(!isPositive(result))
			throw new IllegalArgumentException(SystemMessage.ERROR_IS_NOT_POSITIVE);
		if(!isMultipleOf10(result))
			throw new IllegalArgumentException(SystemMessage.ERROR_IS_NOT_MULTIPLE_OF_10);
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

	private static boolean isMultipleOf10(int number) {
		return number % 10 == 0;
	}
}
