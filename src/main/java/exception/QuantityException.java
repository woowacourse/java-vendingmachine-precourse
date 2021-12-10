package exception;

import static constant.NumberConstant.*;
import static constant.StringConstant.*;

public class QuantityException {
	public static void isValidQuantity(String rawQuantity) {
		try {
			int quantity = isNumber(rawQuantity);
			isPositive(quantity);
		} catch (NumberFormatException e){
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	public static int isNumber(String rawQuantity) {
		try {
			return Integer.parseInt(rawQuantity);
		} catch (NumberFormatException e){
			throw new IllegalArgumentException(NOT_NUMBER);
		}
	}

	public static void isPositive(int quantity) {
		if (quantity > ZERO) {
			return;
		}
		throw new IllegalArgumentException(NOT_POSITIVE);
	}
}
