package vendingmachine;

import java.util.Collections;
import java.util.Map;

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
	public int getAmount() {
		return this.amount;
	}

	public static Coin getCoin(int amount) {
		for (Coin coin : Coin.values()) {
			if (coin.getAmount() == amount) {
				return coin;
			}
		}
		throw new IllegalArgumentException("[ERROR]존재하지 않는 동전입니다.");
	}
}
