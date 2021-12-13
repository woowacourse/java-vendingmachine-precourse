package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Machine {
	private Map<Integer, Integer> coinCount = new HashMap<>();
	private List<Merchandise> merchandiseList = new ArrayList<>();
	private int balance;

	public Machine() {
		for (Integer i : Coin.getCoinList()) {
			coinCount.put(i, 0);
		}
	}

	public void setCoins(int changes) {
		while (changes != 0) {
			int pick = Randoms.pickNumberInList(Coin.getCoinList());
			if (changes - pick < 0) {
				continue;
			}
			coinCount.put(pick, coinCount.get(pick) + 1);
			changes -= pick;
		}
	}

	public Map<Integer, Integer> getSortedCoinCount() {
		Map<Integer, Integer> sortedCoinCount = coinCount.entrySet().stream()
			.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		return sortedCoinCount;
	}

	public void setMerchandise(String merchandiseList) {
		String[] items = merchandiseList.split(";");
		for (String item : items) {
			this.merchandiseList.add(new Merchandise(item));
		}
	}

	public void setPayment(String payment) {
		this.balance = Integer.parseInt(payment);
	}

	public int getCurrentBalance() {
		return balance;
	}

	public boolean isExistItem(String item) {
		for (Merchandise merchandise : merchandiseList) {
			if (merchandise.isSameMerchandise(item)) {
				return true;
			}
		}
		return false;
	}

	public void buyItem(String name) {
		Merchandise item = findItem(name);
		if (item.checkAbleToSell(balance)) {
			balance = item.sell(balance);
		}
	}

	private Merchandise findItem(String name) {
		return merchandiseList.stream()
			.filter(merchandise -> merchandise.isSameMerchandise(name))
			.findAny()
			.orElse(null);
	}

	public boolean checkAbleToBuyItem() {
		if (checkItemsCount() && checkBalance()) {
			return true;
		}
		return false;
	}

	private boolean checkItemsCount() {
		for (Merchandise merchandise : merchandiseList) {
			if (merchandise.isSoldOut()) {
				return false;
			}
		}
		return true;
	}

	private boolean checkBalance() {
		Collections.sort(merchandiseList);
		if (merchandiseList.get(0).checkAbleToSell(balance) == false) {
			return false;
		}
		return true;
	}

	public Map<Integer, Integer> getReturnCoins() {
		Map<Integer, Integer> sortedCoinCount = getSortedCoinCount();
		Map<Integer, Integer> result = new LinkedHashMap<>();
		Iterator<Integer> coins = sortedCoinCount.keySet().iterator();
		while (coins.hasNext() && balance > 0) {
			int coin = coins.next();
			int count = getReturnCoinCount(coin, sortedCoinCount.get(coin));
			if (count != 0) {
				balance -= coin * count;
				result.put(coin, count);
			}
		}
		return result;
	}

	private int getReturnCoinCount(int coin, int remainingCoinCount) {
		int count = balance / coin;
		if (remainingCoinCount < count) {
			count = remainingCoinCount;
		}
		return count;
	}

	private boolean isExistCoin() {
		return Collections.min(coinCount.values()) != 0;
	}
}
