package vendingmachine.model.repository;

import java.util.HashMap;

import vendingmachine.model.Coin;

public class CoinRepository {

	public static final int DEFAULT_COIN_COUNT_NUMBER = 0;

	// Singleton instance of CoinRepository class
	public static CoinRepository instance = new CoinRepository();

	private final HashMap<Coin, Integer> coinRepository;

	private CoinRepository() {
		this.coinRepository = new HashMap<>();
		for (Coin coin : Coin.values()) {
			coinRepository.put(coin, DEFAULT_COIN_COUNT_NUMBER);
		}
	}

	public HashMap<Coin, Integer> getCoinRepository() {
		return coinRepository;
	}
}
