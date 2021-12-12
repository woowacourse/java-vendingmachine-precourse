package vendingmachine.util;

import vendingmachine.constants.ErrorMessage;
import vendingmachine.constants.Rule;

public class NumberException {
	public static int checkMoneyException(String moneyStr) {
		int money;
		try {
			money = Integer.parseInt(moneyStr);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_MONEY__MESSAGE);
		}

		try {
			checkPositiveNumberException(money);
			checkNumberIsDividedTen(money);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

		return money;
	}

	public static void checkPositiveNumberException(int number) {

		if (number <= 0) {
			throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER_MONEY_MESSAGE);
		}

	}

	public static void checkNumberIsDividedTen(int number) {

		if (number % Rule.STANDARD_FOR_DIVIDING != 0) {
			throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDED_TEN_NUMBER_MESSAGE);
		}

	}

	public static int checkPriceException(String priceStr) {
		int price;
		try {
			price = checkMoneyException(priceStr);

			if (price < Rule.LOWER_LIMIT_FOR_PRICE) {
				throw new IllegalArgumentException(ErrorMessage.UNDER_THAN_PRICE_LIMIT_MESSAGE);
			}

		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

		return price;
	}

	public static int checkQuantityException(String quantityStr) {
		int quantity;
		try {
			quantity = Integer.parseInt(quantityStr);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_QUANTITY_MESSAGE);
		}

		try {
			checkPositiveNumberException(quantity);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER_QUANTITY_MESSAGE);
		}

		return quantity;
	}

}
