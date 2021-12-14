package vendingmachine.model.cash.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private static final List<Integer> AMOUNTS = Stream.of(Coin.values())
		.map(Coin::getAmount)
		.collect(Collectors.toList());
	private static final String TO_STRING_AMOUNT_SUFFIX = "원 - ";
	private static final String TO_STRING_COUNT_SUFFIX = "개";

	private final int amount;
	private int count = 0;
	private int changeCount = 0;

	Coin(final int amount) {
		this.amount = amount;
	}

	// 추가 기능 구현
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(amount);
		stringBuilder.append(TO_STRING_AMOUNT_SUFFIX);
		stringBuilder.append(count);
		stringBuilder.append(TO_STRING_COUNT_SUFFIX);
		return stringBuilder.toString();
	}

	public String changeToString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(amount);
		stringBuilder.append(TO_STRING_AMOUNT_SUFFIX);
		stringBuilder.append(changeCount);
		stringBuilder.append(TO_STRING_COUNT_SUFFIX);
		return stringBuilder.toString();
	}

	public static List<Integer> getAmounts() {
		return AMOUNTS;
	}

	public static Coin findByAmount(int amount) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.isAmount(amount))
			.findFirst()
			.orElse(null);
	}

	public boolean isChangeCount(int count) {
		return this.changeCount == count;
	}

	public void add() {
		this.count++;
	}

	public int takeChange(int changeAmount) {
		int required = divideByAmount(changeAmount);
		if (this.count < required) {
			this.changeCount = this.count;
			return take(this.count);
		}
		this.changeCount = required;
		return take(required);
	}

	private int getAmount() {
		return this.amount;
	}

	private boolean isAmount(int amount) {
		return this.amount == amount;
	}

	private int divideByAmount(int dividend) {
		return (dividend / this.amount);
	}

	private int take(int count) {
		this.count = this.count - count;
		return (count * this.amount);
	}
}
