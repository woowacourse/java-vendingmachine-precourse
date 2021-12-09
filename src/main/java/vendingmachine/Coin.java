package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public static Coin random(final int money) {
		List<Coin> randomPool = getRandomPool(money);
		List<Integer> randomPoolIndices = getRandomPoolIndices(randomPool.size());

		return randomPool.get(Randoms.pickNumberInList(randomPoolIndices));
	}

	private static List<Coin> getRandomPool(int money) {
		List<Coin> randomPool = new ArrayList<>();
		List<Coin> coins = Arrays.asList(Coin.values());
		coins.forEach(coin -> {
			if (coin.amount <= money) {
				randomPool.add(coin);
			}
		});

		return randomPool;
	}

	private static List<Integer> getRandomPoolIndices(int length) {
		List<Integer> randomPoolIndices = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			randomPoolIndices.add(i);
		}

		return randomPoolIndices;
	}

	public static boolean isSwappbleForCoin(int money) {
		return COIN_10.amount <= money;
	}

	public int subtract(int money) {
		return money - this.amount;
	}

}
