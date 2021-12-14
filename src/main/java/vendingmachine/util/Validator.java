package vendingmachine.util;

import java.util.regex.Matcher;

import vendingmachine.constant.ErrorConst;
import vendingmachine.domain.Coin;

public class Validator {
	public static void validateMoney(int money) {
		if (isMinus(money)) {
			throw new IllegalArgumentException(ErrorConst.MONEY_IS_NOT_MINUS);
		}
		if (isNotDividedByTen(money)) {
			throw new IllegalArgumentException(ErrorConst.MONEY_IS_DIVIDED_BY_TEN);
		}
	}

	public static void validateItemName(String itemName) {
		if (itemName.trim().equals("")) {
			throw new IllegalArgumentException(ErrorConst.ITEM_NAME_IS_NOT_WHITESPACE);
		}
	}

	public static void validatePrice(int price) {
		if (isUnder100(price)) {
			throw new IllegalArgumentException(ErrorConst.ITEM_PRICE_OVER_ONE_HUNDRED);
		}
		if (isNotDividedByTen(price)) {
			throw new IllegalArgumentException(ErrorConst.MONEY_IS_DIVIDED_BY_TEN);
		}
	}

	public static void validateMatcher(Matcher m) {
		if (isNotMatchingReg(m)) {
			throw new IllegalArgumentException(ErrorConst.ITEM_OUT_OF_FORMAT);
		}
	}

	private static boolean isNotMatchingReg(Matcher m) {
		return !m.matches();
	}

	private static boolean isUnder100(int price) {
		return price < 100;
	}

	private static boolean isMinus(int money) {
		return money < 0;
	}

	private static boolean isNotDividedByTen(int money) {
		return !Coin.COIN_10.isDivided(money);
	}
}
