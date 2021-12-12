package ui;

import java.util.regex.Pattern;

public class InputFormatChecker {
	private static final String NUMBER_REGULAR_EXPRESSION = "^[0-9]+$";
	private static final String FORMAT_ERROR_MESSAGE_ONLY_NUMBER
		= "[ERROR] 숫자만 입력해 주세요.\n";

	private boolean checkFormat(String regularExpression, String target) {
		if (Pattern.matches(regularExpression, target)) {
			return true;
		}
		return false;
	}

	protected boolean checkMoneyFormat(String money) throws IllegalArgumentException {
		if (checkFormat(NUMBER_REGULAR_EXPRESSION, money)) {
			return true;
		}
		throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE_ONLY_NUMBER);
	}
}
