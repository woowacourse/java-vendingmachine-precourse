package vendingmachine.service;

import java.util.Map;
import java.util.TreeMap;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;
import vendingmachine.domain.Quantity;

public class RandomCoinService implements CoinService {

	@Override
	public Map<Coin, Quantity> generateCoinMap(Money money) {
		Map<Coin, Quantity> coins = new TreeMap<>();
		while (money.isGreaterThan(Money.ZERO)) {
			Coin coin = pickOne(money);
			createOrAdd(coins, coin);
			money = money.minus(coin.toMoney());
		}
		return coins;
	}

	private void createOrAdd(Map<Coin, Quantity> coins, Coin coin) {
		if (!coins.containsKey(coin)) {
			coins.put(coin, Quantity.ONE);
			return;
		}
		coins.put(coin, coins.get(coin).plus(Quantity.ONE));
	}

	private Coin pickOne(Money money) {
		Coin coin = Coin.pickRandom();
		if (!money.isLessThan(coin.toMoney())) {
			return coin;
		}
		return pickOne(money);
	}
}
