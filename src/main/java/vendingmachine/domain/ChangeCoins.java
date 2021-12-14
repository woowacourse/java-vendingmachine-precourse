package vendingmachine.domain;

import static vendingmachine.Constants.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChangeCoins {
	private Map<Coin, Integer> coins = new LinkedHashMap<>();

	public ChangeCoins(Long money) {
		initializeCoins();
		makeChangeCoinsFrom(money);
	}

	public Map<Coin, Integer> getCoins() {
		return coins;
	}

	public Map<Coin, Integer> getChangeCoinsFromMoney(long amount) {
		Map<Coin, Integer> usedCoin = new LinkedHashMap<>();
		Iterator<Coin> iterator = coins.keySet().iterator();
		while (iterator.hasNext()) {
			amount = setChangeCoin(amount, usedCoin, iterator);
		}
		return removeZeroCountCoins(usedCoin);
	}

	private long setChangeCoin(long amount, Map<Coin, Integer> usedCoin, Iterator<Coin> iterator) {
		Coin coin = iterator.next();
		int maxCount = coin.calculateMaxCount(amount);
		if (maxCount < coins.get(coin)) {
			usedCoin.put(coin, maxCount);
			return amount - coin.multipleCount(maxCount);
		}
		usedCoin.put(coin, coins.get(coin));
		return amount - coin.multipleCount(coins.get(coin));
	}

	private Map<Coin, Integer> removeZeroCountCoins(Map<Coin, Integer> usedCoin) {
		Iterator<Coin> iterator = usedCoin.keySet().iterator();
		while (iterator.hasNext()) {
			removeZeroCoin(usedCoin, iterator);
		}
		return usedCoin;
	}

	private void removeZeroCoin(Map<Coin, Integer> usedCoin, Iterator<Coin> iterator) {
		Coin coin = iterator.next();
		if (usedCoin.get(coin) == COIN_COUNT_ZERO) {
			iterator.remove();
		}
	}

	private void makeChangeCoinsFrom(Long money) {
		while (money != 0) {
			Coin selectedCoin = selectCoin(money);
			coins.put(selectedCoin, coins.get(selectedCoin) + ADD_COIN_COUNT);
			money = subtractCoinAmount(selectedCoin, money);
		}
	}

	private void initializeCoins() {
		Arrays.asList(Coin.values()).stream()
			.forEach(coin -> coins.put(coin, INITIAL_COIN_COUNT));
	}

	private Coin selectCoin(long money) {
		return Coin.randomCoinFrom(money);
	}

	private long subtractCoinAmount(Coin coin, long money) {
		return coin.subtractAmountFrom(money);
	}
}
