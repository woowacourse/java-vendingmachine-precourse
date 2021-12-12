package vendingmachine.utils;

public class Validator {
	private static final String NUMBER_PATTERN = "^[0-9]+$";
	private static final String NAME_PATTERN = "^[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+$";

	private static void validatePositive(String input) throws IllegalArgumentException {
		if (Integer.valueOf(input) <= 0) {
			throw new IllegalArgumentException(
				Messages.ERROR_NOT_POSITIVE.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
		}
	}

	private static void validateNumber(String input) throws IllegalArgumentException {
		if (!input.matches(NUMBER_PATTERN)) {
			throw new IllegalArgumentException(
				Messages.ERROR_NOT_NUMBER.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
		}
	}

	private static void validateName(String input) throws IllegalArgumentException {
		if (!input.matches(NAME_PATTERN)) {
			throw new IllegalArgumentException(
				Messages.ERROR_NOT_VALID_NAME.getValue() + Messages.COMMON_LINE_BREAK_MSG.getValue());
		}
	}
}
