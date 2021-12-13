package vendingmachine.domain;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
	private Map<Integer, Integer> coinCount = new HashMap<>();
	private int amount;

	public Coins() {
	}

	public Coins(int amount) {
		this.amount = amount;
		for (Integer i : Coin.getCoinList()) {
			coinCount.put(i, 0);
		}
	}

	public void pickCoins() {
		int amount = this.amount;
		while (amount != 0) {
			int pick = Randoms.pickNumberInList(Coin.getCoinList());
			if (amount - pick < 0) {
				continue;
			}
			coinCount.put(pick, coinCount.get(pick) + 1);
			amount -= pick;
		}
	}

	public Map<Integer, Integer> getSortedCoinCount() {
		Map<Integer, Integer> sortedCoinCount = coinCount.entrySet().stream()
			.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		return sortedCoinCount;
	}

	public int getCoinCount(int coin) {
		return coinCount.get(coin);
	}

	public void changeCoinCount(int coin, int count) {
		coinCount.put(coin, count);
	}

}
