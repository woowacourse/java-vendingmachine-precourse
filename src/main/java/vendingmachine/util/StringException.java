package vendingmachine.util;

import vendingmachine.constants.ErrorMessage;
import vendingmachine.constants.Rule;

public class StringException {

	public static String checkNameException(String productName) {
		try {
			checkNameIsBlank(productName);
			checkSpaceInProductName(productName);
			checkTabInProductName(productName);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

		return productName;
	}

	public static void checkNameIsBlank(String name) {
		if (name.equals(Rule.NOTHING)) {
			throw new IllegalArgumentException(ErrorMessage.BLANK_PRODUCT_NAME_MESSAGE);
		}
	}

	public static void checkSpaceInProductName(String name) {
		String[] tmp = name.split(Rule.SPACE, -1);

		if (tmp.length != 1) {
			throw new IllegalArgumentException(ErrorMessage.SPACE_IN_PRODUCT_NAME_MESSAGE);
		}

	}

	public static void checkTabInProductName(String name) {
		String[] tmp = name.split(Rule.TAB, -1);

		if (tmp.length != 1) {
			throw new IllegalArgumentException(ErrorMessage.TAB_IN_PRODUCT_NAME_MESSAGE);
		}

	}
}
