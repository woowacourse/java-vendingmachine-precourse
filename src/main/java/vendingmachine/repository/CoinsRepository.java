package vendingmachine.repository;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.CoinQuantity;

public class CoinsRepository {
	private static final int INITIAL_COIN_QUANTITY = 0;

	private static final CoinsRepository coinsRepository = new CoinsRepository();
	private final Map<Coin, CoinQuantity> coins = new HashMap<>();

	private CoinsRepository() {
		coins.put(Coin.COIN_500, CoinQuantity.from(INITIAL_COIN_QUANTITY));
		coins.put(Coin.COIN_100, CoinQuantity.from(INITIAL_COIN_QUANTITY));
		coins.put(Coin.COIN_50, CoinQuantity.from(INITIAL_COIN_QUANTITY));
		coins.put(Coin.COIN_10, CoinQuantity.from(INITIAL_COIN_QUANTITY));
	}

	public static CoinsRepository getInstance() {
		return coinsRepository;
	}

	public void updateByCoin(Coin coin, CoinQuantity coinQuantity) {
		coins.put(coin, coinQuantity);
	}

	public CoinQuantity findByCoin(Coin coin) {
		return coins.get(coin);
	}

	public Map<Coin, CoinQuantity> findAll() {
		return this.coins;
	}
}
