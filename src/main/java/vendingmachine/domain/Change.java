package vendingmachine.domain;

import java.util.Map;
import java.util.TreeMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Change {

	private static Map<Coin, Integer> changes = new TreeMap<>();

	public Change(Map<Coin, Integer> changes) {
		Change.changes = changes;
	}

	public Map<Coin, Integer> getChanges() {
		return changes;
	}

	public static Change generateChanges(Money money) {
		initChanges();
		int tmpMoney = 0;

		while (!money.isSame(tmpMoney)) {
			int random = Randoms.pickNumberInList(Coin.getList());
			if (random == money.getTotal()) {
				continue;
			}
			if (money.isSmaller(tmpMoney + random)) {
				continue;
			}
			tmpMoney += random;
			Coin coin = Coin.getCoin(random);
			changes.put(coin, changes.get(coin) + 1);
		}
		return new Change(changes);
	}

	public Money getTotalChange() {
		int total = 0;
		for (Coin coin : changes.keySet()) {
			total += coin.getAmount() * changes.get(coin);
		}
		return new Money(total);
	}

	private static void initChanges() {
		changes.put(Coin.COIN_500, 0);
		changes.put(Coin.COIN_100, 0);
		changes.put(Coin.COIN_50, 0);
		changes.put(Coin.COIN_10, 0);
	}
}
