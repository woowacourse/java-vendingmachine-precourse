package vendingmachine.util;

import java.util.Arrays;
import java.util.List;

import vendingmachine.constant.Message;

public class SplitChecker {

	public void hasZeroLength(String input, String DELIMETER) {
		List<String> inputList = Arrays.asList(input.split(DELIMETER, -1));

		for (String productInfo : inputList) {

			if (productInfo.length() == 0) {
				throw new IllegalArgumentException(Message.ERROR_MESSAGE_LENGTH_ZERO);
			}

		}

	}
}
