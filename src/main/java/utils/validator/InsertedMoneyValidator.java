package utils.validator;

import java.util.regex.Pattern;

public class InsertedMoneyValidator {
	private static final int MIN_INSERTED_MONEY_INPUT_LENGTH = 1;
	private static final String ZERO = "0";
	private static final String BLANK = " ";
	private static final String MONEY_PATTERN = "^[0-9]+$";
	private static final String INPUT_NOTHING_ERROR_MESSAGE = "[ERROR] 입력한 투입 금액이 없다.";
	private static final String HAS_BLANK_ERROR_MESSAGE = "[ERROR] 입력한 투입 금액에 공백이 있다.";
	private static final String NOT_RIGHT_INSERTED_MONEY_ERROR_MESSAGE = "[ERROR] 입력한 투입 금액이 올바른수(양수)가 아니다.";
	private static final String START_INSERTED_MONEY_NUMBER_ERROR_MESSAGE = "[ERROR] 입력한 투입 금액이 0으로 시작한다.";

	private InsertedMoneyValidator() {
	}

	public static int checkValidInsertedMoney(String insertedMoney) {
		if (isValidInputLength(insertedMoney) && !hasBlankInInput(insertedMoney) && isRightMoneyNumber(insertedMoney)) {
			return Integer.parseInt(insertedMoney);
		}
		throw new IllegalArgumentException();
	}

	private static boolean isValidInputLength(String insertedMoney) {
		if (insertedMoney.length() < MIN_INSERTED_MONEY_INPUT_LENGTH) {
			throw new IllegalArgumentException(INPUT_NOTHING_ERROR_MESSAGE);
		}
		return true;
	}

	private static boolean hasBlankInInput(String insertedMoney) {
		if (insertedMoney.contains(BLANK)) {
			throw new IllegalArgumentException(HAS_BLANK_ERROR_MESSAGE);
		}
		return false;
	}

	private static boolean isRightMoneyNumber(String insertedMoney) {
		if (!Pattern.matches(MONEY_PATTERN, insertedMoney)) {
			throw new IllegalArgumentException(NOT_RIGHT_INSERTED_MONEY_ERROR_MESSAGE);
		}
		if (insertedMoney.startsWith(ZERO)) {
			throw new IllegalArgumentException(START_INSERTED_MONEY_NUMBER_ERROR_MESSAGE);
		}
		return true;
	}
}
