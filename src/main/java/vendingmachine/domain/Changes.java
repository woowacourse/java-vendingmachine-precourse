package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

public class Changes {
	private Map<Coin, Integer> changes = new LinkedHashMap<>();

	{
		for (Coin coin : Coin.values()) {
			changes.put(coin, 0);
		}
	}

	public Changes() {
	}

	public Map<Coin, Integer> getChanges() {
		return changes;
	}

	public void setChanges(Coin coin, int count) {
		changes.replace(coin, count);
	}

	public void setRandomChanges(Money money) {
		int amount = money.getAmount();
		while (amount > 0) {
			int coinAmount = Randoms.pickNumberInList(Coin.getAmountList());
			Coin coin = Coin.findToAmount(coinAmount);
			if (amount < coinAmount) {
				continue;
			}
			amount -= coinAmount;
			changes.replace(coin, changes.get(coin) + 1);
		}
	}

	public Changes toChangesMinCount(Money insertMoney) {
		Changes changes = new Changes();
		int amount = insertMoney.getAmount();
		for (Coin coin : Coin.values()) {
			int count = Math.min(this.changes.get(coin), amount / coin.getAmount());
			changes.setChanges(coin, count);
			amount -= coin.getAmount() * count;
		}
		return changes;
	}

	public Money getTotalMoney() {
		Money money = new Money(0);
		for (Map.Entry<Coin, Integer> coinInteger : changes.entrySet()) {
			money = money.plus(new Money(coinInteger.getKey().getAmount() * coinInteger.getValue()));
		}
		return money;
	}
}
