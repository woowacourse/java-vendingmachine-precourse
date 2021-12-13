package utils.validator;

import java.util.regex.Pattern;

public class ChangeValidator {
	private static final int MINIMUM_CHANGE_MONEY_UNIT = 10;
	private static final int RIGHT_NUMBER = 0;
	private static final int MIN_CHANGE_INPUT_LENGTH = 1;
	private static final String ZERO = "0";
	private static final String BLANK = " ";
	private static final String CHANGE_NUMBER_PATTERN = "^[0-9]+$";
	private static final String INPUT_NOTHING_ERROR_MESSAGE = "[ERROR] 입력한 자판기 잔돈이 없다.";
	private static final String HAS_BLANK_ERROR_MESSAGE = "[ERROR] 입력한 자판기 잔돈에 공백이 있다.";
	private static final String NOT_RIGHT_CHANGE_NUMBER_ERROR_MESSAGE = "[ERROR] 입력한 자판기 잔돈이 올바른수(양수)가 아니다.";
	private static final String START_CHANGE_NUMBER_ERROR_MESSAGE = "[ERROR] 입력한 자판기 잔돈이 0으로 시작한다.";
	private static final String NOT_RIGHT_CHANGE_MONEY_UNIT_ERROR_MESSAGE = "[ERROR] 입력한 자판기 잔돈이 10으로 나누어 떨어지지 않는다.";

	private ChangeValidator() {
	}

	public static int checkValidChange(String change) {
		if (isValidInputLength(change) && !hasBlankInInput(change) && isRightChangeNumber(change)
			&& isDivisibleByMinimumMoneyUnit(change)) {
			return Integer.parseInt(change);
		}
		throw new IllegalArgumentException();
	}

	private static boolean isValidInputLength(String change) {
		if (change.length() < MIN_CHANGE_INPUT_LENGTH) {
			throw new IllegalArgumentException(INPUT_NOTHING_ERROR_MESSAGE);
		}
		return true;
	}

	private static boolean hasBlankInInput(String change) {
		if (change.contains(BLANK)) {
			throw new IllegalArgumentException(HAS_BLANK_ERROR_MESSAGE);
		}
		return false;
	}

	private static boolean isRightChangeNumber(String change) {
		if (!Pattern.matches(CHANGE_NUMBER_PATTERN, change)) {
			throw new IllegalArgumentException(NOT_RIGHT_CHANGE_NUMBER_ERROR_MESSAGE);
		}
		if (change.startsWith(ZERO)) {
			throw new IllegalArgumentException(START_CHANGE_NUMBER_ERROR_MESSAGE);
		}
		return true;
	}

	private static boolean isDivisibleByMinimumMoneyUnit(String change) {
		if (Integer.parseInt(change) % MINIMUM_CHANGE_MONEY_UNIT != RIGHT_NUMBER) {
			throw new IllegalArgumentException(NOT_RIGHT_CHANGE_MONEY_UNIT_ERROR_MESSAGE);
		}
		return true;
	}
}
