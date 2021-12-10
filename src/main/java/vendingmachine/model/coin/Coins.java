package vendingmachine.model.coin;

import static java.util.Comparator.comparingInt;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Coins {
	private final Map<Coin, Integer> coins;

	public Coins() {
		coins = initCoins();
	}

	private Map<Coin, Integer> initCoins() {
		final Map<Coin, Integer> coins = new HashMap<>();
		coins.put(Coin.COIN_500, 0);
		coins.put(Coin.COIN_100, 0);
		coins.put(Coin.COIN_50, 0);
		coins.put(Coin.COIN_10, 0);
		return coins;
	}

	public void put(Coin coin) {
		coins.put(coin, coins.get(coin) + 1);
	}

	public int getCount(Coin coin) {
		return coins.get(coin);
	}

	public Stream<Coin> stream() {
		return coins.keySet().stream().sorted(comparingInt(Coin::getAmount).reversed());
	}

	public boolean isLessOrEquals(int money) {
		return getTotalAmount() <= money;
	}

	private int getTotalAmount() {
		return stream().mapToInt(this::getEachAmount).sum();
	}

	private int getEachAmount(Coin coin) {
		return coin.getAmount() * getCount(coin);
	}
}
