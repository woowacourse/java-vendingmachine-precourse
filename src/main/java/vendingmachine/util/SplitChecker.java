package vendingmachine.util;

import java.util.Arrays;
import java.util.List;

import vendingmachine.constant.Message;

public class SplitChecker {

	public void exceedMaxSplit(String input, String DELIMETER) {
		try {
			String[] test = input.split(DELIMETER, -1);
		} catch (Exception e) {
			throw new IllegalArgumentException(Message.ERROR_EXCEED_INTEGER);
		}
	}

	public void hasZeroLength(String input, String DELIMETER) {
		List<String> inputList = Arrays.asList(input.split(DELIMETER, -1));

		for (String productInfo : inputList) {

			if (productInfo.length() == 0) {
				throw new IllegalArgumentException(Message.ERROR_LENGTH_ZERO);
			}

		}

	}

	public void isCorrectTheNumber(String input, String DELIMETER, int correctTheNumber) {
		List<String> inputList = Arrays.asList(input.split(DELIMETER, -1));

		if (inputList.size() != correctTheNumber) {
			throw new IllegalArgumentException(correctTheNumber + Message.ERROR_THE_NUMBER_OF);
		}

	}
}
