package vendingmachine.model;

import java.util.HashMap;
import java.util.Map;
import vendingmachine.utils.exception.MoneyException;

public class Changes {

	private final Map<Coin, Integer> changes;
	private final CoinCase coinCase;
	private int remainInsertMoney;

	public Changes(CoinCase coinCase, int remainInsertMoney) {
		MoneyException.validateMoney(remainInsertMoney);
		this.coinCase = coinCase;
		this.remainInsertMoney = remainInsertMoney;
		this.changes = calculateChanges();
	}

	public Map<Coin, Integer> getChanges() {
		return changes;
	}

	private Map<Coin, Integer> calculateChanges() {
		Map<Coin, Integer> change = new HashMap<>();
		for (Coin coin : Coin.values()) {
			int changeCount = coinCase.returnChange(coin, remainInsertMoney / coin.getAmount());
			remainInsertMoney -= changeCount * coin.getAmount();
			change.put(coin, changeCount);
		}
		return change;
	}
}
