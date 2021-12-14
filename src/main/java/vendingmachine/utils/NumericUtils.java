package vendingmachine.utils;

import static vendingmachine.resource.MessageResource.*;

public class NumericUtils {
	private NumericUtils() {
	}

	public static int parsePositiveInt(String str) {
		try {
			int result = Integer.parseInt(str.trim());

			if (result <= 0) {
				throw new IllegalArgumentException(ERROR_NUMBER_IS_NOT_POSITIVE_INT);
			}
			return result;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_AMOUNT_IS_NOT_NUMERIC);
		}
	}
}
