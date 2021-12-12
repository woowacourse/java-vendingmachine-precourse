package vendingmachine.util;

import java.util.regex.Matcher;

import vendingmachine.constant.ErrorConst;
import vendingmachine.domain.Coin;

public class Validator {
	public static void validateInitialMoney(int money) {
		if (isMinus(money)) {
			throw new IllegalArgumentException(ErrorConst.MONEY_IS_NOT_MINUS);
		}
		if (isNotDividedByTen(money)) {
			throw new IllegalArgumentException(ErrorConst.MONEY_IS_DIVIDED_BY_TEN);
		}
	}

	public static void validateItemName(String itemName) {
		// 상품명이 공백만 있을 경우
		if (itemName.trim().equals("")) {
			throw new IllegalArgumentException("[ERROR] 상품명으로 공백을 지정할 수 없습니다.");
		}
		//TODO 상품명이 중복될 경우
	}

	public static void validatePrice(int price) {
		// 100원 이상인지 체크
		if (isUnder100(price)) {
			throw new IllegalArgumentException(ErrorConst.ITEM_PRICE_OVER_ONE_HUNDRED);
		}
		// 10원으로 나누어 떨어지는지 체크
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
