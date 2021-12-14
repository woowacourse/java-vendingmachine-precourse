package vendingmachine.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.type.Coin;

public class CoinProcessor {

	private Map<Coin, Integer> coinMap = new HashMap<Coin, Integer>();

	public void generateCoinMap(int money) {
		List<Integer> coins = new ArrayList<Integer>();
		while (money != 0) {
			int coinValue = getRandomCoin();
			if (coinValue > money) {
				continue;
			}
			coins.add(coinValue);
			money -= coinValue;
		}
		initCoinMap(coins);
	}

	public Map<Coin, Integer> generateChangeMap(int change) {
		Map<Coin, Integer> result = new HashMap<Coin, Integer>();
		for (Coin coin : Coin.getCoinList()) {
			int numberOfChangeCoin = getNumberOfChangeCoin(change, coin, coinMap.get(coin));
			result.put(coin, numberOfChangeCoin);
			change -= numberOfChangeCoin * coin.getAmount();
		}
		return result;
	}

	private int getNumberOfChangeCoin(int change, Coin coin, int quantity) {
		int maximumChange = change / coin.getAmount();
		if (quantity < maximumChange) {
			return maximumChange = quantity;
		}
		return maximumChange;
	}

	private void initCoinMap(List<Integer> coins) {
		for (Coin coin : Coin.getCoinList()) {
			coinMap.put(coin, Collections.frequency(coins, coin.getAmount()));
		}
	}

	private int getRandomCoin() {
		return Randoms.pickNumberInList(Coin.getCoinValues());
	}

	public Map<Coin, Integer> getCoinMap() {
		return coinMap;
	}
}
