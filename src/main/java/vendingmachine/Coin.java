package vendingmachine;

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
		try {
			List<Integer> coinList = getSwappableCoinList(money);
			int pickedCoinAmount = Randoms.pickNumberInList(coinList);
			return findCoinByAmount(pickedCoinAmount);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return pickRandom(money);
		}
	}

	private static Coin findCoinByAmount(final int coinAmount) throws IllegalArgumentException {
		Coin[] coinList = Coin.values();
		for (Coin coin : coinList) {
			if (coin.amount == coinAmount) {
				return coin;
			}
		}
		throw new IllegalArgumentException("[ERROR] Unexpected Behavior");
	}

	private static List<Integer> getSwappableCoinList(final int money) {
		List<Coin> coins = Arrays.asList(Coin.values());
		List<Coin> generalizableCoins = coins.stream()
			.filter(coin -> coin.amount <= money)
			.collect(Collectors.toList());
		return generalizableCoins.stream().map(coin -> coin.amount).collect(Collectors.toList());
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
