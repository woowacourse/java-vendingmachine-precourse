package vendingmachine.model;

import java.util.Arrays;

public enum Coin implements Comparable<Coin> {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final Money amount;
	private int count;

	Coin(final int amount) {
		this.amount = Money.from(amount);
		this.count = 0;
	}

	public static Coin from(Money amount) {
		return Arrays.stream(values())
			.filter(coin -> coin.isAmountExactly(amount))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR]"));
	}

	private boolean isAmountExactly(Money amount) {
		return this.amount.equals(amount);
	}

	//테스팅을 위한 함수
	protected static void resetForTest() {
		Arrays.stream(Coin.values())
			.forEach(coin -> coin.count = 0);
	}

	public void addOne() {
		count++;
	}

	public Money getAmount() {
		return amount;
	}

	public int getCount() {
		return count;
	}

	public Money totalAmount() {
		return totalAmountOfCount(count);
	}

	public Money totalAmountOfCount(int count) {
		return amount.totalAmountOfCount(count);
	}

	public int getMaxCountLessThan(Money balance) {
		if (totalAmount().isValuableThan(balance)) {
			return balance.getMaxCountOfCoin(amount);
		}
		return count;
	}

	public boolean isRemain() {
		return count > 0;
	}
}
