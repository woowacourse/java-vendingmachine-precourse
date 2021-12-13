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
	private static final String PRINT_WON = "원 - ";

	public int getAmount() {
		return amount;
	}

	Coin(final int amount) {
		this.amount = amount;
	}

	public static List<Integer> getCoinAmountList() {
		return Arrays.asList(Coin.values())
			.stream()
			.map(coin -> coin.getAmount())
			.collect(Collectors.toList());
	}

	public static Coin getCoinByNumber(int randomCoin) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.getAmount() == randomCoin)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("동전을 찾을 수 없습니다."));

	}

	@Override
	public String toString() {
		return amount + PRINT_WON;
	}
}
