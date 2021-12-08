package vendingmachine.repository;

import static vendingmachine.NumberConstant.*;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.domain.Coin;

public class CoinRepository {

	private static final Map<Coin, Integer> coinRepository = new HashMap<>();

	public CoinRepository() {
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
}
