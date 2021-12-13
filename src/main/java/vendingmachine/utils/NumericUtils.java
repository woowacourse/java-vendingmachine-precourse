package vendingmachine.utils;

import static vendingmachine.resource.MessageResource.*;

public class NumericUtils {
	private NumericUtils() {
	}

	public static int parseInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_AMOUNT_IS_NOT_NUMERIC);
		}
	}
}
