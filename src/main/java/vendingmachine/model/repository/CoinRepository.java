package vendingmachine.model.repository;

import java.util.HashMap;

import vendingmachine.model.Coin;

public class CoinRepository {

	public static final int DEFAULT_COIN_COUNT_NUMBER = 0;

	// Singleton instance of CoinRepository class
	public static CoinRepository instance = new CoinRepository();

	private final HashMap<String, Integer> coinRepository;

	private CoinRepository() {
		this.coinRepository = new HashMap<>();
		for (Coin coin : Coin.values()) {
			coinRepository.put(String.valueOf(coin.getAmount()), DEFAULT_COIN_COUNT_NUMBER);
		}
	}

	public HashMap<String, Integer> getCoinRepository() {
		return coinRepository;
	}
}
