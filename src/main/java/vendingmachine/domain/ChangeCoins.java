package vendingmachine.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChangeCoins {
	private Map<Coin, Integer> coins = new LinkedHashMap<>();

	public ChangeCoins(Long money) {
		initializeCoins();
		makeChangeCoinsFrom(money);
	}

	private void makeChangeCoinsFrom(Long money) {
		while (money != 0) {
			Coin selectedCoin = selectCoin(money);
			coins.put(selectedCoin, coins.get(selectedCoin) + 1);
			money = subtractCoinAmount(selectedCoin, money);
		}
	}

	private void initializeCoins() {
		Arrays.asList(Coin.values()).stream()
			.forEach(coin -> coins.put(coin, 0));
	}

	private Coin selectCoin(long money) {
		return Coin.randomCoinFrom(money);
	}

	private long subtractCoinAmount(Coin coin, long money) {
		return coin.subtractAmountFrom(money);
	}
}
