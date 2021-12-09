package vendingmachine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;
	private int count = 0;
	private static List<Integer> amounts = Stream.of(Coin.values())
		.map(Coin::getAmount)
		.collect(Collectors.toList());

	Coin(final int amount) {
		this.amount = amount;
	}

	// 추가 기능 구현
	public int getAmount() {
		return this.amount;
	}

	public int getCount() {
		return this.count;
	}

	public static List<Integer> getAmounts() {
		return amounts;
	}

	public static Coin findByAmount(int amount) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.isAmount(amount))
			.findFirst()
			.orElse(null);
	}

	public boolean isAmount(int amount) {
		return this.amount == amount;
	}

	public void add() {
		this.count++;
	}
}
