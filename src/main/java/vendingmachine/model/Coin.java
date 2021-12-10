package vendingmachine.model;

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

	Coin(final int amount) {
		this.amount = amount;
	}

	public static List<Integer> toList() {
		return Stream.of(Coin.values())
			.map(Coin::getAmount)
			.collect(Collectors.toList());
	}

	public static Coin of(int amount) {
		return Arrays.stream(values())
			.filter(coin -> coin.getAmount() == amount)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("Coin을 찾을 수 없습니다."));
	}

	public int getAmount() {
		return amount;
	}

}
