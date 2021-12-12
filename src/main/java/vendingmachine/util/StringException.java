package vendingmachine.util;

import vendingmachine.constants.ErrorMessage;
import vendingmachine.constants.Rule;

public class StringException {

	public static String checkStringException(String str) {
		try {
			checkStringIsBlank(str);
			checkSpaceInString(str);
			checkTabInString(str);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

		return str;
	}

	public static void checkStringIsBlank(String str) {
		if (str.equals(Rule.NOTHING)) {
			throw new IllegalArgumentException(ErrorMessage.BLANK_PRODUCT_NAME_MESSAGE);
		}
	}

	public static void checkSpaceInString(String str) {
		String[] tmp = str.split(Rule.SPACE, -1);

		if (tmp.length != 1) {
			throw new IllegalArgumentException(ErrorMessage.SPACE_IN_PRODUCT_NAME_MESSAGE);
		}

	}

	public static void checkTabInString(String str) {
		String[] tmp = str.split(Rule.TAB, -1);

		if (tmp.length != 1) {
			throw new IllegalArgumentException(ErrorMessage.TAB_IN_PRODUCT_NAME_MESSAGE);
		}

	}

}
