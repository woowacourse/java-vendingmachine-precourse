package vendingmachine.model;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinBucket {
	private final List<Coin> coins;

	//테스팅을 위해
	protected CoinBucket() {
		coins = initCoins();
	}

	private List<Coin> initCoins() {
		return Arrays.stream(Coin.values())
			.sorted()
			.collect(toList());
	}

	public static CoinBucket of(Money assets, CoinGenerator generator) {
		CoinBucket coinBucket = new CoinBucket();
		while (assets.isRemain()) {
			Coin coin = generator.generateCoinWithMoney(assets);
			coinBucket.addCoin(coin);
		}
		return coinBucket;
	}

	private void addCoin(Coin coin) {
		if (contains(coin)) {
			coin.addOne();
		}
	}

	private boolean contains(Coin coin) {
		return coins.contains(coin);
	}

	public Map<Coin, Integer> getCoins() {
		Map<Coin, Integer> currentCoins = new HashMap<>();
		for (Coin coin : coins) {
			currentCoins.put(coin, coin.getCount());
		}
		return Collections.unmodifiableMap(currentCoins);
	}

	public Map<Coin, Integer> getChanges(Money balance) {
		Map<Coin, Integer> changes = new HashMap<>();

		for (Coin coin : coins) {
			int count = coin.getMaxCountLessThan(balance);
			balance.use(coin.totalAmountOfCount(count));
			if (canAddToBalance(count)) {
				changes.put(coin, count);
			}
		}
		return Collections.unmodifiableMap(changes);
	}

	private boolean canAddToBalance(int count) {
		return count > 0;
	}
}
