package vendingmachine.util;

import vendingmachine.domain.Coin;

public class Validator {
	public static void validateInitialMoney(int money) {
		if (money < 0) {
			throw new IllegalArgumentException("[ERROR] 금액은 자연수여야 합니다.");
		}
		if (isNotDividedByTen(money)) {
			throw new IllegalArgumentException("[ERROR] 금액은 10원 단위로 나누어 떨어져야합니다.");
		}
	}

	private static boolean isNotDividedByTen(int money) {
		return !Coin.COIN_10.isDivided(money);
	}
}
