package vendingmachine.domain.coin;

import static vendingmachine.constant.ErrorMessage.*;

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

	public static List<Coin> getAllCoin() {
		return Arrays.stream(Coin.values())
			.collect(Collectors.toList());
	}

	public static Coin getCoinByAmount(int amount) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.amount == amount)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(COIN_IS_NOT_EXISTENT_ERROR_MESSAGE));
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return Integer.toString(amount);
	}
}
