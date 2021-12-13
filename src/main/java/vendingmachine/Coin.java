package vendingmachine;

import java.util.Arrays;

public enum Coin implements Comparable<Coin> {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;
	private int count;

	Coin(final int amount) {
		this.amount = amount;
		this.count = 0;
	}

	public static Coin from(int amount) {
		return Arrays.stream(values())
			.filter(coin -> coin.isAmountExactly(amount))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR]"));
	}

	private boolean isAmountExactly(int amount) {
		return this.amount == amount;
	}

	public void addOne() {
		count++;
	}

	public int getAmount() {
		return amount;
	}

	public int getCount() {
		return count;
	}
}
