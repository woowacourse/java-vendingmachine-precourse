package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static int getRandomCoin() {
		List<Integer> coinValues = new ArrayList<>();
		for (Coin coin : Coin.values()) {
			coinValues.add(coin.amount);
		}
		return Randoms.pickNumberInList(coinValues);
	}

	public static Coin nameOf(int randCoin) {
		for (Coin coinName : Coin.values()) {
			if (coinName.getAmount() == randCoin) {
				return coinName;
			}
		}
		return null;
	}

	private int getAmount() {
		return amount;
	}
}
