package vendingmachine.util;

import vendingmachine.constants.ErrorMessage;

public class NumberException {
	public static int money = 0;

	public static int checkMoneyException(String moneyStr) {
		try {
			money = Integer.parseInt(moneyStr);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_MONEY__MESSAGE);
		}

		if (!checkPositiveNumberMoneyException(money)) {
			throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER_MONEY_MESSAGE);
		}

		if (!checkNumberIsDividedTen(money)) {
			throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDED_TEN_NUMBER_MESSAGE);
		}

		return money;
	}

	public static boolean checkPositiveNumberMoneyException(int number) {

		if (number <= 0) {
			return false;
		}

		return true;
	}

	public static boolean checkNumberIsDividedTen(int number) {

		if (number % 10 != 0) {
			return false;
		}

		return true;
	}

	public static int checkPriceException(String priceStr) {
		int price;
		try {
			price = checkMoneyException(priceStr);

			if (price < 100) {
				throw new IllegalArgumentException(ErrorMessage.UNDER_THAN_PRICE_LIMIT_MESSAGE;
			}

		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

		return price;
	}

}
