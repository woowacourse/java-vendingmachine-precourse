package vendingmachine.domain;

import java.util.Map;
import java.util.NoSuchElementException;

public class CoinGenerator {

	public Map<Coin, Quantity> generate(Money money, CoinPickStrategy pickStrategy) {
		Map<Coin, Quantity> coins = Coin.createEmpty();
		addCoinRecursively(coins, money, pickStrategy);
		return coins;
	}

	private void addCoinRecursively(Map<Coin, Quantity> coins, Money money, CoinPickStrategy pickStrategy) {
		while (money.isGreaterThan(Money.ZERO)) {
			try {
				Coin coin = findCoin(money, pickStrategy);
				add(coins, coin);
				money = decrease(money, coin);
			} catch (NoSuchElementException exception) {
				return;
			}
		}
	}

	private Money decrease(Money money, Coin coin) {
		return money.minus(coin.toMoney());
	}

	private Coin findCoin(Money money, CoinPickStrategy pickStrategy) {
		return pickStrategy.pickOne(money);
	}

	private void add(Map<Coin, Quantity> coins, Coin coin) {
		coins.put(coin, coins.get(coin).plus(Quantity.ONE));
	}
}
