package model.coin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	// 추가 기능 구현
	public static Coin getValueByPrice(int coinPrice) {
		if (coinPrice == 500) {
			return COIN_500;
		} else if (coinPrice == 100) {
			return COIN_100;
		} else if (coinPrice == 50) {
			return COIN_50;
		}
		return COIN_10;
	}

	public static List<Coin> getValues() {
		return Arrays.stream(Coin.values()).collect(Collectors.toList());
	}

	public int getAmount() {
		return amount;
	}
}
