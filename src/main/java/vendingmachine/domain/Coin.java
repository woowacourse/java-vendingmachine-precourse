package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
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

	// 추가 기능 구현

	public int getAmount() {
		return amount;
	}

	public static Coin getCoinByNumber(int number) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.getAmount() == number)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException());
	}

	public static List<Integer> getCoinList() {
		return Arrays.stream(Coin.values()).map(coin -> coin.amount).collect(Collectors.toList());
	}
}
