package vendingmachine.util;

import vendingmachine.constant.Message;
import vendingmachine.constant.Rule;

public class StringChecker {

	public void isEmpty(String input) {

		if (input.equals(Message.EMPTY)) {
			throw new IllegalArgumentException(Message.ERROR_INPUT_IS_EMPTY);
		}

	}

	public void containSpace(String input) {

		if (input.contains(Message.SPACE)) {
			throw new IllegalArgumentException(Message.ERROR_CONTAINS_SPACE);
		}

	}

	public void containTap(String input) {

		if (input.contains(Message.TAP)) {
			throw new IllegalArgumentException(Message.ERROR_CONTAINS_TAP);
		}

	}

	public void inBracket(String input) {

		if (input.length() <= 2 || input.charAt(0) != Rule.BRACKET.charAt(0) ||
			input.charAt(input.length() - 1) != Rule.BRACKET.charAt(1)) {
			throw new IllegalArgumentException(Message.ERROR_NOT_BRACKET);
		}

	}

	public void isLessMaxLength(String input, int maxLength) {

		if (input.length() > maxLength) {
			throw new IllegalArgumentException(maxLength + Message.ERROR_EXCEED_MAX_LENGTH);
		}

	}
}
