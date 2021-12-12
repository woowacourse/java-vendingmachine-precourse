package vendingmachine.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import vendingmachine.enums.Coin;

public class CoinRepository {
	private static final String INIT_QUANTITY = "0";
	private static final int ONE = 1;

	private static final Map<Coin, Quantity> coins = new HashMap<>();

	static {
		coins.put(Coin.COIN_500, new Quantity(INIT_QUANTITY));
		coins.put(Coin.COIN_100, new Quantity(INIT_QUANTITY));
		coins.put(Coin.COIN_50, new Quantity(INIT_QUANTITY));
		coins.put(Coin.COIN_10, new Quantity(INIT_QUANTITY));
	}

	public static Quantity findQuantityByCoin(Coin coin) {
		return coins.get(coin);
	}

	public static void addOneQuantityByAmount(int amount) {
		coins.get(Coin.findByAmount(amount)).add(ONE);
	}

	public static void sub(Coin coin, Quantity quantity) {
		coins.get(coin).sub(quantity.get());
	}

	public static Map<Coin, Quantity> findAll() {
		return Collections.unmodifiableMap(coins);
	}

	public static void clear() {
		coins.put(Coin.COIN_500, new Quantity(INIT_QUANTITY));
		coins.put(Coin.COIN_100, new Quantity(INIT_QUANTITY));
		coins.put(Coin.COIN_50, new Quantity(INIT_QUANTITY));
		coins.put(Coin.COIN_10, new Quantity(INIT_QUANTITY));
	}
}
