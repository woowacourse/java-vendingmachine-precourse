package exception;

import static constant.NumberConstant.*;
import static constant.StringConstant.*;

public class PriceException {
	public static void isValidPrice(String rawPrice) {
		try {
			int price = isNumber(rawPrice);
			isPositive(price);
			isCoinValue(price);
		} catch (NumberFormatException e){
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	public static int isNumber(String rawPrice) {
		try {
			return Integer.parseInt(rawPrice);
		} catch (NumberFormatException e){
			throw new IllegalArgumentException(NOT_NUMBER);
		}
	}

	public static void isPositive(int price) {
		if (price > ZERO) {
			return;
		}
		throw new IllegalArgumentException(NOT_POSITIVE);
	}

	public static void isCoinValue(int price) {
		if (price % MIN_COIN_UNIT != ZERO) {
			throw new IllegalArgumentException(NOT_COIN_VALUE);
		}
	}
}
