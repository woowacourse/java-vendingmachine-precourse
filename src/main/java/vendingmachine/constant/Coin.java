package vendingmachine.constant;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

	public int getAmount() {
		return amount;
	}

	public static Optional<Coin> ofAmount(int amount) {
		return Arrays.stream(Coin.values()).filter(coin -> coin.getAmount() == amount).findAny();
	}

	public static List<Integer> getAmountList() {
		return Arrays.stream(Coin.values()).map(Coin::getAmount).collect(Collectors.toList());
	}
}
