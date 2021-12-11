package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private static final String  NO_COIN_MESSAGE = "해당 금액의 코인을 찾을 수 없습니다.";
	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public static List<Integer> getAmountList(int money) {
		return Arrays.asList(Coin.values()).stream()
			.map(Coin::getAmount)
			.filter(amount -> amount <= money)
			.collect(Collectors.toList());
	}

	public static Coin getCoinByAmount(int amount) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.amount == amount)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(NO_COIN_MESSAGE));
	}

	@Override
	public String toString() {
		return amount + "원";
	}

}
