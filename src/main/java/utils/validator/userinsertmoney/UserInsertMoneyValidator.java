package utils.validator.userinsertmoney;

import java.util.regex.Pattern;

public class UserInsertMoneyValidator {
	private static final int MIN_USER_INSERT_MONEY_INPUT_LENGTH = 1;
	private static final String ZERO = "0";
	private static final String BLANK = " ";
	private static final String MONEY_PATTERN = "^[0-9]+$";
	private static final String INPUT_NOTHING_ERROR_MESSAGE = "[ERROR] 입력한 투입 금액이 없다.";
	private static final String HAS_BLANK_ERROR_MESSAGE = "[ERROR] 입력한 투입 금액에 공백이 있다.";
	private static final String NOT_RIGHT_MONEY_ERROR_MESSAGE = "[ERROR] 입력한 투입 금액이 올바른수(양수)가 아니다.";
	private static final String START_MONEY_NUMBER_ERROR_MESSAGE = "[ERROR] 입력한 투입 금액이 0으로 시작한다.";

	private UserInsertMoneyValidator() {
	}

	public static int checkValidUserInsertMoney(String userInsertMoney) {
		if (isValidInputLength(userInsertMoney) && !hasBlankInInput(userInsertMoney) && isRightNumber(
			userInsertMoney)) {
			return Integer.parseInt(userInsertMoney);
		}
		throw new IllegalArgumentException();
	}

	private static boolean isValidInputLength(String userInsertMoney) {
		if (userInsertMoney.length() < MIN_USER_INSERT_MONEY_INPUT_LENGTH) {
			throw new IllegalArgumentException(INPUT_NOTHING_ERROR_MESSAGE);
		}
		return true;
	}

	private static boolean hasBlankInInput(String userInsertMoney) {
		if (userInsertMoney.contains(BLANK)) {
			throw new IllegalArgumentException(HAS_BLANK_ERROR_MESSAGE);
		}
		return false;
	}

	private static boolean isRightNumber(String userInsertMoney) {
		if (!Pattern.matches(MONEY_PATTERN, userInsertMoney)) {
			throw new IllegalArgumentException(NOT_RIGHT_MONEY_ERROR_MESSAGE);
		}
		if (userInsertMoney.startsWith(ZERO)) {
			throw new IllegalArgumentException(START_MONEY_NUMBER_ERROR_MESSAGE);
		}
		return true;
	}
}
