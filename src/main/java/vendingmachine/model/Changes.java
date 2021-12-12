package vendingmachine.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vendingmachine.utils.exception.MoneyException;

public class Changes {

	private final Map<Integer, Integer> changes;
	private final List<CoinCase> coinCases;
	private int remainInsertMoney;
	private static final int INITIAL_VALUE = 0;

	public Changes(List<CoinCase> coinCases, int remainInsertMoney) {
		MoneyException.validateMoney(remainInsertMoney);
		this.coinCases = coinCases;
		this.remainInsertMoney = remainInsertMoney;
		this.changes = calculateChanges();
	}

	public Map<Integer, Integer> getChanges() {
		return changes;
	}

	private Map<Integer, Integer> calculateChanges() {
		Map<Integer, Integer> change = new HashMap<>();
		for (CoinCase coinCase : coinCases) {
			if (remainInsertMoney == INITIAL_VALUE) {
				break;
			}
			int coinType = coinCase.getCoin().getAmount();
			int changeCount = coinCase.returnChange(remainInsertMoney / coinType);
			remainInsertMoney -= changeCount * coinType;
			change.put(coinType, changeCount);
		}
		return change;
	}
}
