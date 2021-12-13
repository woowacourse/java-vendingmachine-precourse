package vendingmachine.domain.coin;

import java.util.Arrays;
import java.util.Comparator;
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

	public static int getSmallestCoinAmount() {
		List<Integer> allCoinAmount = getAllCoinAmount();
		return allCoinAmount.get(allCoinAmount.size() - 1);
	}

	public static int getSecondBiggestCoinAmount() {
		List<Integer> allCoinAmount = getAllCoinAmount();
		return allCoinAmount.get(1);
	}

	public static List<Integer> getAllCoinAmount() {
		return Arrays.stream(Coin.values())
			.map(coin -> coin.amount)
			.sorted(Comparator.reverseOrder())
			.collect(Collectors.toList());
	}
}
