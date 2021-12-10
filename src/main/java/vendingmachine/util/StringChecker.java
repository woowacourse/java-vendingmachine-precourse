package vendingmachine.util;

import vendingmachine.constant.Message;

public class StringChecker {

	public void isEmpty(String input) {

		if (input.equals(Message.EMPTY)) {
			throw new IllegalArgumentException(Message.ERROR_MESSAGE_INPUT_IS_EMPTY);
		}

	}

	public void containSpace(String input) {

		if (input.contains(Message.SPACE)) {
			throw new IllegalArgumentException(Message.ERROR_MESSAGE_CONTAINS_SPACE);
		}

	}

	public void containTap(String input) {

		if (input.contains(Message.TAP)) {
			throw new IllegalArgumentException(Message.ERROR_MESSAGE_CONTAINS_TAP);
		}

	}
}
