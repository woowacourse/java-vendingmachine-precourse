package vendingmachine.domain;

import static vendingmachine.utils.ExceptionMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	public static int MINIMUM_COIN = 10;
	public static final String WON_REPRESENT_UNIT = "원";
	public static final String COIN_REPRESENT_UNIT = "개";
	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static List<Integer> findCoinListByInteger() {
		return Arrays.stream(values())
			.map(Coin::getAmount)
			.collect(Collectors.toList());
	}

	public int getAmount() {
		return amount;
	}

	public static boolean checkIsAtLeastCoin(int money) {
		return money >= MINIMUM_COIN;
	}

	public static Coin findCoin(int coin) {
		return Arrays.stream(values())
			.filter(coinOfCoins -> coinOfCoins.amount == coin)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_INPUT_AMOUNT));
	}

	public static List<Coin> getCoinList() {
		return Arrays.stream(Coin.values())
			.collect(Collectors.toList());
	}

	public int getChangeAmount(int amount) {
		return amount - getAmount();
	}

	@Override
	public String toString() {
		return getAmount() + WON_REPRESENT_UNIT;
	}
}
