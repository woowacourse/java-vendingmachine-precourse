package vendingmachine.domain;

import java.util.Map;
import java.util.TreeMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Change {

	private final Map<Coin, Integer> changes;

	public Change() {
		changes = new TreeMap<>();
	}

	public Change(Map<Coin, Integer> changes) {
		this.changes = changes;
	}

	public Map<Coin, Integer> getChanges() {
		return changes;
	}

	public void generateChanges(Money money) {
		initChanges();
		int tmpMoney = 0;
		while (!money.isSame(tmpMoney)) {
			int random = Randoms.pickNumberInList(Coin.getList());
			if (notValidChange(money, tmpMoney, random)) {
				continue;
			}
			tmpMoney += random;
			Coin coin = Coin.getCoin(random);
			changes.put(coin, changes.get(coin) + 1);
		}
	}

	private static boolean notValidChange(Money money, int tmpMoney, int random) {
		return random == money.getTotal() || money.isSmaller(tmpMoney + random);
	}

	private void initChanges() {
		this.changes.put(Coin.COIN_500, 0);
		this.changes.put(Coin.COIN_100, 0);
		this.changes.put(Coin.COIN_50, 0);
		this.changes.put(Coin.COIN_10, 0);
	}
}
