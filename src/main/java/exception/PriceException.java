package exception;

import static constant.NumberConstant.*;
import static constant.StringConstant.*;

public class PriceException {
	public static int isValidPrice(String rawPrice) {
		try {
			int price = Integer.parseInt(rawPrice);
			isPositive(price);
			return price;
		} catch (NumberFormatException e){
			throw new IllegalArgumentException(PRICE_NOT_NUMBER);
		}
	}

	private static void isPositive(int price) {
		if (price > ZERO) {
			isCoinValue(price);
			return;
		}
		throw new IllegalArgumentException(PRICE_NOT_POSITIVE);
	}

	private static void isCoinValue(int price) {
		if (price % MIN_COIN_UNIT != ZERO) {
			throw new IllegalArgumentException(PRICE_NOT_COIN_VALUE);
		}
	}
}
