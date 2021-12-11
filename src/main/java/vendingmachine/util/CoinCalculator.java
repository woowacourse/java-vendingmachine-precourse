package vendingmachine.util;

import vendingmachine.model.Coin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class CoinCalculator {
	public HashMap<Integer, Integer> combineCoinsByGreedy(HashMap<Coin, Integer> coins, int remainMoney) {
		HashMap<Integer, Integer> returnCoins = new HashMap<>(Coin.getCoinTypes());
		List<Integer> coinAmounts = Coin.getCoinAmounts();
		for (int amount : coinAmounts) {
			Coin coin = Coin.getCoinByAmount(amount);
			int count = getMaxCoinCount(coin, coins.get(coin), remainMoney);
			if (count != 0) {
				returnCoins.put(coin.getAmount(), count);
			}
			remainMoney -= coin.getAmount() * count;
		}
		return returnCoins;
	}

	private int getMaxCoinCount(Coin coin, int count, int money) {
		int max = 0;
		for (int i = 0; i <= count; i++) {
			if (coin.getAmount() * i <= money) {
				max = i;
			}
		}
		return max;
	}
}
