package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
	private static final int COIN_AMOUNT_ZERO = 0;
	private static final int COIN_DEFAULT_QUANTITY = 0;
	private static final int COIN_QUANTITY_PLUS = 1;

	final Map<Coin, Integer> coins;

	public Coins(Map<Coin, Integer> coins) {
		this.coins = coins;
	}

	public Coins from(int coinsAmount) {
		return new Coins(generateRandomCoins(coinsAmount));
	}

	private Map<Coin, Integer> generateRandomCoins(int inputCoinsAmount) {
		final List<Integer> coinsType = Coin.getCoinsAmount();
		Map<Coin, Integer> randomCoins = initRandomCoins();

		while (inputCoinsAmount != COIN_AMOUNT_ZERO) {
			final int randomCoinAmount = Randoms.pickNumberInList(coinsType);
			final Coin randomCoin = Coin.valueOf(randomCoinAmount);

			if (inputCoinsAmount - randomCoinAmount >= COIN_AMOUNT_ZERO) {
				inputCoinsAmount -= randomCoinAmount;
				randomCoins.put(randomCoin, randomCoins.get(randomCoin) + COIN_QUANTITY_PLUS);
			}
		}

		return randomCoins;
	}

	private Map<Coin, Integer> initRandomCoins() {
		Map<Coin, Integer> initCoins = new LinkedHashMap<>();
		for (Coin coin : Coin.values()) {
			initCoins.put(coin, COIN_DEFAULT_QUANTITY);
		}

		return initCoins;
	}
}
