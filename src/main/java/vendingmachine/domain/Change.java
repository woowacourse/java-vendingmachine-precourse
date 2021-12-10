package vendingmachine.domain;

import java.util.Map;
import java.util.TreeMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Change {
	private int money;
	private static final Map<Coin, Integer> changes = new TreeMap<>();

	public Change(int money) {
		initChanges();
		this.money = money;
	}

	public static Map<Coin, Integer> getChanges() {
		return changes;
	}

	public Map<Coin, Integer> generateChanges() {
		int tmpMoney = 0;
		while (tmpMoney != money) {
			int random = Randoms.pickNumberInList(Coin.getList());
			if (money < tmpMoney + random) {
				continue;
			}
			tmpMoney += random;
			Coin coin = Coin.getCoin(random);
			changes.put(coin, changes.get(coin) + 1);
		}
		return changes;
	}

	private void initChanges() {
		changes.put(Coin.COIN_500, 0);
		changes.put(Coin.COIN_100, 0);
		changes.put(Coin.COIN_50, 0);
		changes.put(Coin.COIN_10, 0);
	}
}
