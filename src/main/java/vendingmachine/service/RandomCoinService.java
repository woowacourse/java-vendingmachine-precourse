package vendingmachine.service;

import java.util.Map;
import java.util.TreeMap;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;

public class RandomCoinService implements CoinService {

	@Override
	public Map<Coin, Integer> generateCoinMap(Money money) {
		Map<Coin, Integer> coins = new TreeMap<>();
		while (money.isGreaterThan(Money.ZERO)) {
			Coin coin = pickOne(money);
			createOrAdd(coins, coin);
			money = money.minus(coin.toMoney());
		}
		return coins;
	}

	private void createOrAdd(Map<Coin, Integer> coins, Coin coin) {
		if (!coins.containsKey(coin)) {
			coins.put(coin, 1);
			return;
		}
		coins.put(coin, coins.get(coin) + 1);
	}

	private Coin pickOne(Money money) {
		Coin coin = Coin.pickRandom();
		if (!money.isLessThan(coin.toMoney())) {
			return coin;
		}
		return pickOne(money);
	}
}
