package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private static final String WON = "원";

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	// 추가 기능 구현
	public int getAmount() {
		return amount;
	}

	public static List<Integer> amountValues() {
		return Arrays.stream(Coin.values()).map(Coin::getAmount).collect(Collectors.toList());
	}

	public static Coin valueOf(int amount) {
		return Arrays.stream(Coin.values()).filter(coin -> coin.getAmount() == amount).findFirst().orElse(null);
	}

	@Override
	public String toString() {
		return amount + WON;
	}
}
