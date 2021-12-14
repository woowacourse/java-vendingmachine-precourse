package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
	COIN_500(500, "500원"),
	COIN_100(100, "100원"),
	COIN_50(50, "50원"),
	COIN_10(10, "10원");

	private final int amount;
	public final String message;

	Coin(final int amount, final String message) {
		this.amount = amount;
		this.message = message;
	}

	public static Coin pickRandom(final int money) {
		List<Coin> randomPool = getRandomPool(money);
		List<Integer> randomPoolIndices = getRandomPoolIndices(randomPool.size());
		return randomPool.get(Randoms.pickNumberInList(randomPoolIndices));
	}

	private static List<Coin> getRandomPool(final int money) {
		List<Coin> coins = Arrays.asList(Coin.values());
		return coins.stream().filter(coin -> coin.amount <= money).collect(Collectors.toList());
	}

	private static List<Integer> getRandomPoolIndices(final int length) {
		List<Integer> randomPoolIndices = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			randomPoolIndices.add(i);
		}
		return randomPoolIndices;
	}

	public static boolean isSwappableForCoin(final int money) {
		return COIN_10.amount <= money;
	}

	public int subtract(final int money) {
		return money - this.amount;
	}

	public int divide(final int money) {
		return money / this.amount;
	}

	public int subtractByGivenNumberOfCoins(final int money, final int numberOfCoins) {
		return money - numberOfCoins * this.amount;
	}
}
