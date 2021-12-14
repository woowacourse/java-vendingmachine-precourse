package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class CoinGenerator {

	public Map<Coin, Quantity> generate(Money money, CoinPickStrategy pickStrategy) {
		Map<Coin, Quantity> coins = new LinkedHashMap<>();
		addCoinRecursively(coins, money, pickStrategy);
		return coins;
	}

	private void addCoinRecursively(Map<Coin, Quantity> coins, Money money, CoinPickStrategy pickStrategy) {
		if (!money.isGreaterThan(Money.ZERO)) {
			return;
		}
		try {
			Coin coin = findCoin(money, pickStrategy);
			createOrAdd(coins, coin);
			money = decrease(money, coin);
		} catch (NoSuchElementException exception) {
			return;
		}
		addCoinRecursively(coins, money, pickStrategy);
	}

	private Money decrease(Money money, Coin coin) {
		return money.minus(coin.toMoney());
	}

	private Coin findCoin(Money money, CoinPickStrategy pickStrategy) {
		return pickStrategy.pickOne(money);
	}

	private void createOrAdd(Map<Coin, Quantity> coins, Coin coin) {
		if (!coins.containsKey(coin)) {
			coins.put(coin, Quantity.ONE);
			return;
		}
		coins.put(coin, coins.get(coin).plus(Quantity.ONE));
	}
}
