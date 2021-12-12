package vendingmachine.domain.coin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {

	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private static final String ERROR_NO_VALUE = "해당 가격의 코인은 존재하지 않습니다.";

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public static Coin valueOf(int amount) {
		Coin[] coins = values();
		return Arrays.stream(coins)
			.filter(coin -> coin.getAmount() == amount)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NO_VALUE));
	}

	public static Coin getMinPriceCoin() {
		List<Integer> amountList = Arrays.stream(values())
			.map(Coin::getAmount)
			.collect(Collectors.toList());
		int minPrice = Collections.min(amountList);
		return valueOf(minPrice);
	}
}
