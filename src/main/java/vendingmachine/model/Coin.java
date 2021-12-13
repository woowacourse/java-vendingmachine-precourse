package vendingmachine.model;

import java.util.Arrays;
import java.util.stream.Collectors;
import vendingmachine.utils.exception.MoneyException;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;
	private static final int INITIAL_VALUE = 0;

	Coin(final int amount) {
		MoneyException.validateMoney(amount);
		this.amount = amount;
	}

	// 추가 기능 구현
	public int getAmount() {
		return amount;
	}

	public static Coin getCoinEqualAmount(int amount) {
		return Arrays.stream(Coin.values()).filter(coin -> coin.amount == amount)
			.collect(Collectors.toList()).get(INITIAL_VALUE);
	}
}
