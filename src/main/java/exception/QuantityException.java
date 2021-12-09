package exception;

import static constant.NumberConstant.*;
import static constant.StringConstant.*;

public class QuantityException {
	public static int isValidQuantity(String rawQuantity) {
		try {
			int quantity = Integer.parseInt(rawQuantity);
			isPositive(quantity);
			return quantity;
		} catch (NumberFormatException e){
			throw new IllegalArgumentException(NOT_NUMBER);
		}
	}

	private static void isPositive(int quantity) {
		if (quantity > ZERO) {
			return;
		}
		throw new IllegalArgumentException(NOT_POSITIVE);
	}
}
