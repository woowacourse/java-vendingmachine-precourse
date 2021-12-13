package vendingmachine.domain.machine.coin.storage;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.domain.machine.coin.Coin;

public class CoinStorageImpl implements CoinStorage {

	Map<Coin, Integer> coinCounts = new HashMap<>();

	public CoinStorageImpl() {
		init();
	}

	private void init() {
		for (Coin coin : Coin.values()) {
			coinCounts.put(coin, 0);
		}
	}

	@Override
	public void save(Coin coin) {
		int count = coinCounts.get(coin);
		coinCounts.put(coin, count + 1);
	}

}
