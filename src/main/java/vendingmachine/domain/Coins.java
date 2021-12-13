package vendingmachine.domain;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {
	private Map<Integer, Integer> coinCount = new HashMap<>();

	public Coins(int amount) {
		for (Integer i : Coin.getCoinList()) {
			coinCount.put(i, 0);
		}
		pickCoins(amount);
	}

	private void pickCoins(int amount) {
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

	private int getCoinCount(int coin) {
		return coinCount.get(coin);
	}

	public Map<Integer, Integer> returnToMinCount(int balance) {
		Map<Integer, Integer> change = new LinkedHashMap<>();
		Iterator<Integer> coins = getSortedCoinCount().keySet().iterator();
		while (coins.hasNext() && balance > 0) {
			int coin = coins.next();
			int count = calcReturnCount(coin, balance);
			if (count != 0) {
				balance -= coin * count;
				coinCount.put(coin, getCoinCount(coin) - count);
				change.put(coin, count);
			}
		}
		return change;
	}

	private int calcReturnCount(int coin, int balance) {
		int count = balance / coin;
		if (getCoinCount(coin) < count) {
			count = getCoinCount(coin);
		}
		return count;
	}
}
