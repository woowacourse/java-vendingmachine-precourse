package vendingmachine.domain.coin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private static final String ERROR_NOT_COIN = "해당 가격의 코인은 없습니다.";
	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static List<Integer> getCoinsAmount() {
		return Arrays.stream(Coin.values())
			.map(coin -> coin.amount)
			.collect(Collectors.toList());
	}

	public static Coin valueOf(int coinAmount) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.isSameAmount(coinAmount))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_COIN));
	}

	private boolean isSameAmount(int coinAmount) {
		return this.amount == coinAmount;
	}

	public int getAmount() {
		return amount;
	}
}
