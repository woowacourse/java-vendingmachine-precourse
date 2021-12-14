package vendingmachine.domain.machine.coin.storage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import vendingmachine.domain.machine.coin.Coin;
import vendingmachine.domain.machine.coin.CoinCountFormatter;
import vendingmachine.domain.user.User;

public class CoinStorageImpl implements CoinStorage {

	Map<Coin, Integer> coinCounts = new LinkedHashMap<>();

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

	@Override
	public void refund(User user) {
		for (Coin coin : coinCounts.keySet()) {
			if (coin.isBiggerThan(user.getCurrentMoney())) {
				continue;
			}
			if (isCoinNoMore(coin)) {
				continue;
			}
			transferCoins(user, coin);
		}
	}

	private boolean isCoinNoMore(Coin coin) {
		return (coinCounts.get(coin) <= 0);
	}

	private void transferCoins(User user, Coin coin) {
		while (user.hasNotLessThan(coin.getAmount())) {
			if (isCoinNoMore(coin)) {
				break;
			}
			user.saveCoin(coin);
			decreaseCoinCount(coin);
			user.withdrawMoney(coin.getAmount());
		}
	}

	private void decreaseCoinCount(Coin coin) {
		int count = coinCounts.get(coin);
		coinCounts.put(coin, count - 1);
	}

	@Override
	public List<String> getAllCoinsAsString() {
		List<String> results = new ArrayList<>();
		for (Map.Entry<Coin, Integer> entry : coinCounts.entrySet()) {
			Coin coin = entry.getKey();
			Integer count = entry.getValue();
			results.add(CoinCountFormatter.of(coin, count));
		}
		return results;
	}

	@Override
	public List<String> getExistedCoinsAsString() {
		List<String> results = new ArrayList<>();
		for (Map.Entry<Coin, Integer> entry : coinCounts.entrySet()) {
			Coin coin = entry.getKey();
			if (isCoinNoMore(coin)) {
				continue;
			}
			Integer count = entry.getValue();
			results.add(CoinCountFormatter.of(coin, count));
		}
		return results;
	}

}
