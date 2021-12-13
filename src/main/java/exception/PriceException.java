package exception;

import static constant.NumberConstant.*;
import static constant.StringConstant.*;

/*
금액 입력에 대한 검증
 */
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

	//10원(최소 동전 단위)으로 나누어 떨어지는 지 검증
	public static void isCoinValue(int price) {
		if (price % MIN_COIN_UNIT != ZERO) {
			throw new IllegalArgumentException(NOT_COIN_VALUE);
		}
	}

	public static void isProductPrice(int price) {
		if (price < MIN_PRODUCT_PRICE) {
			throw new IllegalArgumentException(LESS_PRODUCT_PRICE);
		}
	}
}
