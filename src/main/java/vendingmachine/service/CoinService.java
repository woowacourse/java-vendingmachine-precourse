package vendingmachine.service;

import static vendingmachine.NumberConstant.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import vendingmachine.domain.Coin;

public class CoinService {

	private static final Map<Coin, Integer> coinRepository = new HashMap<>();

	public CoinService() {
		if (coinRepository.isEmpty()) {
			coinRepository.put(Coin.COIN_10, ZERO);
			coinRepository.put(Coin.COIN_50, ZERO);
			coinRepository.put(Coin.COIN_100, ZERO);
			coinRepository.put(Coin.COIN_500, ZERO);
		}
	}

	public void register(int money) {
		while (money > ZERO) {
			Coin coin = Coin.getRandom();

			if (coin.isSmall(money)) {
				addCoinCount(coin);
				money = coin.subtractAmount(money);
			}
		}
	}

	private void addCoinCount(Coin coin) {
		int count = coinRepository.get(coin);
		coinRepository.put(coin, ++count);
	}

	public int getCoinCount(int amount) {
		return coinRepository.get(Coin.getByAmount(amount));
	}

	public Map<Coin, Integer> returnChange(int money) {
		Map<Coin, Integer> change = new HashMap<>();
		Iterator<Coin> iter = Arrays.stream(Coin.values()).iterator();

		while (money > ZERO && iter.hasNext()) {
			Coin coin = iter.next();
			int changeCount = getMaxChangeCount(money, coin);
			change.put(coin, changeCount);
			subtractCoinCount(coin, changeCount);

			money -= coin.multiplyCount(changeCount);
		}

		return change;
	}

	private void subtractCoinCount(Coin coin, int count) {
		int coinCount = coinRepository.get(coin);
		coinRepository.put(coin, coinCount - count);

		if (coinCount < count) {
			coinRepository.put(coin, ZERO);
		}
	}

	public int getMaxChangeCount(int money, Coin coin) {
		int changeCount = coin.getChangeCount(money);
		int coinCount = coinRepository.get(coin);

		return Math.min(changeCount, coinCount);
	}
}
