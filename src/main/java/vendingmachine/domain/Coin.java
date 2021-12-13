package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.utils.ErrorMessage;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public static List<Integer> toListWithLimit(int amountLimit) {
		return Arrays.asList(Coin.values()).stream()
			.map(Coin::getAmount)
			.filter(amount -> amount <= amountLimit)
			.collect(Collectors.toList());
	}

	public static Coin from(int amount) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.amount == amount)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NO_COIN_MESSAGE));
	}

	@Override
	public String toString() {
		return amount + "원";
	}

}
