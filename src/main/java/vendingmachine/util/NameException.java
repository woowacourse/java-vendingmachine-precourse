package vendingmachine.util;

import vendingmachine.constants.ErrorMessage;

public class NameException {

	public static String checkNameException(String productName) {
		try {
			checkSpaceInProductName(productName);
			checkTabInProductName(productName);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

		return productName;
	}

	public static void checkSpaceInProductName(String name) {
		String[] tmp = name.split(" ", -1);

		if (tmp.length != 1) {
			throw new IllegalArgumentException(ErrorMessage.SPACE_IN_PRODUCT_NAME_MESSAGE);
		}

	}

	public static boolean checkTabInProductName(String name) {
		String[] tmp = name.split("\t", -1);

		if (tmp.length != 1) {
			throw new IllegalArgumentException(ErrorMessage.TAB_IN_PRODUCT_NAME_MESSAGE);
		}

	}
}
