package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
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
}
