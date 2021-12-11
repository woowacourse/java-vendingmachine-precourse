package vendingmachine.model;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
	COIN_500("500원", 500),
	COIN_100("100원", 100),
	COIN_50("50원", 50),
	COIN_10("10원", 10);

	private final String unit;
	private final int amount;

	Coin(final String unit, final int amount) {
		this.unit = unit;
		this.amount = amount;
	}

	public static Coin valueOf(int amount) {
		if (amount == 500) {
			return COIN_500;
		} else if (amount == 100) {
			return COIN_100;
		} else if (amount == 50) {
			return COIN_50;
		}
		return COIN_10;
	}

	public static int pickRandom() {
		return Randoms.pickNumberInList(
			Arrays.asList(COIN_500.amount, COIN_100.amount, COIN_50.amount, COIN_10.amount));
	}

	public String getUnit() {
		return this.unit;
	}

	public int getAmount() {
		return this.amount;
	}
}
