package vendingmachine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	public static final List<Integer> LIST_OF_MONEY = Arrays.stream(values())
		.map(coin -> coin.amount)
		.collect(Collectors.toList());

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public static Coin pickRandomCoin() {
		int amount = Randoms.pickNumberInList(LIST_OF_MONEY);
		if (amount == COIN_500.amount) {
			return COIN_500;
		}
		if (amount == COIN_100.amount) {
			return COIN_100;
		}
		if (amount == COIN_50.amount) {
			return COIN_50;
		}
		return COIN_10;
	}

	public static boolean hasEnoughMoney(int target, Coin coin) {
		return target >= coin.amount;
	}

	public boolean hasBiggerAmount(int target) {
		return this.amount>target;
	}

}
