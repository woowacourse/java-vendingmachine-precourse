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

	public Changes(Money money) {
		setRandomChanges(money);
	}

	private void setRandomChanges(Money money) {
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

	public Map<Coin, Integer> getChanges() {
		return changes;
	}
}
