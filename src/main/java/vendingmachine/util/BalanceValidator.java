package vendingmachine.util;

import vendingmachine.domain.Items;

public class BalanceValidator {
	private static final String ERROR = "[ERROR] ";
	private static final String NOT_NUMBER_ERROR = "금액은 숫자여야 합니다.";
	private static final String NOT_DIVIDABLE_ERROR = "금액은 10원 단위로 나누어져야 합니다.";
	private static final String NOT_POSITIVE_ERROR = "금액은 양수여야 합니다.";
	private static final String NOTHING_TO_BUY = "투입하신 금액이 부족합니다.";

	private static final int TEN_WON = 10;
	private static final int ZERO_WON = 0;

	public static int isValidBalance(String input) {
		int balance = isDigit(input);
		isDividable(balance);
		isPositive(balance);
		return balance;
	}

	private static int isDigit(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR + NOT_NUMBER_ERROR);
		}
	}

	private static void isDividable(int balance) {
		if (balance % TEN_WON != ZERO_WON) {
			throw new IllegalArgumentException(ERROR + NOT_DIVIDABLE_ERROR);
		}
	}

	private static void isPositive(int balance) {
		if (balance < ZERO_WON) {
			throw new IllegalArgumentException(ERROR + NOT_POSITIVE_ERROR);
		}
	}

	public static void isEnoughBalance(int balance, Items items) {
		if (balance < items.getExistingCheapest()) {
			throw new IllegalArgumentException(ERROR + NOTHING_TO_BUY);
		}
	}
}
