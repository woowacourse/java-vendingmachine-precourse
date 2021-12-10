package vendingmachine.util;

import java.util.Arrays;
import java.util.List;

import vendingmachine.constant.Message;
import vendingmachine.constant.Rule;

public class SplitChecker {

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

	public void hasZeroLength(String input) {
		List<String> inputList = Arrays.asList(input.split(Rule.DELIMETER_PRODUCT, -1));

		for (String productInfo : inputList) {

			if (productInfo.length() == 0) {
				throw new IllegalArgumentException(Message.ERROR_MESSAGE_LENGTH_ZERO);
			}

		}

	}
}
