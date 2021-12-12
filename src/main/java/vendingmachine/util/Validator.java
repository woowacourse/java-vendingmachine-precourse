package vendingmachine.util;

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

	private static boolean isMinus(int money) {
		return money < 0;
	}

	private static boolean isNotDividedByTen(int money) {
		return !Coin.COIN_10.isDivided(money);
	}
}
