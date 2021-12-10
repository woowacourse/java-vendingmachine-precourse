package vendingmachine.domain;

import java.util.Arrays;

public enum Coin {
	COIN_500(500) {
	},
	COIN_100(100) {
	},
	COIN_50(50) {
	},
	COIN_10(10) {
	};

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public static Coin getCoinByAmount(int amount) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.amount == amount)
			.findFirst()
			.orElseThrow(IllegalAccessError::new);
	}

	@Override
	public String toString() {
		return amount + "원";
	}

}
