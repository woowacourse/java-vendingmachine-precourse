package vendingmachine.domain;

import static constants.VendingMachineConstants.*;

import java.util.Arrays;

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
			.filter(coin -> coin.checkAmount(amount))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(COIN_NOT_FOUND_ERROR));
	}

	private boolean checkAmount(int amount) {
		return this.amount == amount;
	}

	@Override
	public String toString() {
		return amount + KOR_MONETARY_UNIT + DASH_WITH_SPACE;
	}
}
