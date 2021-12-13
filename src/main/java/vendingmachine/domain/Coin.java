package vendingmachine.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	static final String MONETARY_UNIT = "원";
	private static final Coin[] coins = Coin.values();
	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static Coin getByAmount(int amount) {
		return Arrays.stream(coins)
			.filter(coin -> coin.getAmount() == amount)
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}

	public static List<Integer> amountList() {
		return Arrays.stream(coins)
			.map(Coin::getAmount)
			.sorted(Comparator.reverseOrder())
			.collect(Collectors.toList());
	}

	private int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return amount + MONETARY_UNIT;
	}
}
