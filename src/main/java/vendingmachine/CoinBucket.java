package vendingmachine;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoinBucket {
	private final List<Coin> coins;

	public CoinBucket() {
		coins = initCoins();
	}

	private List<Coin> initCoins() {
		return Arrays.stream(Coin.values())
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

	public List<Coin> getCoins() {
		return Collections.unmodifiableList(coins);
	}
}
