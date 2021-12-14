package vendingmachine.domain;

import java.util.Arrays;

import vendingmachine.utils.Message;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static Coin findByAmount(int amount) {
		return Arrays.stream(Coin.values())
			.filter(e -> e.amount == amount)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(Message.REQUEST_MESSAGE_THERE_IS_NO_COIN));
	}

	public int toAmount() {
		return this.amount;
	}
}
