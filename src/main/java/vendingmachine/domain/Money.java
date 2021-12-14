package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Money {
	private static final String INSERTED_AMOUNT = "투입 금액";
	private static final String BLANK = " ";
	private static final String COLON = ":";
	private static final String WON = "원";
	private static final int ZERO = 0;
	private int money;

	public Money(final int money) {
		this.money = money;
	}

	public void pay(final int moneyAmount) {
		reduce(moneyAmount);
	}

	private void reduce(final int moneyAmount) {
		money -= moneyAmount;
	}

	public Map<Integer, Integer> makeChanges(final Coins coins) {
		Map<Integer, Integer> changes = new LinkedHashMap<>();
		for (Map.Entry<Integer, Integer> coin : coins.findRestCoins().entrySet()) {
			int number = getAvailableChangeNumber(coin.getKey(), coin.getValue(), money);
			updateChangesAndMoney(changes, coin.getKey(), number);
		}
		return changes;
	}

	private int getAvailableChangeNumber(final int coin, final int number, final int money) {
		if (coin * number > money) { // 동전 총액 > 투입 금액인 경우 (example: 100원 * 3 (300원) > 투입금액 200원)
			return money / coin;
		}
		return number;
	}

	private void updateChangesAndMoney(final Map<Integer, Integer> changes, final Integer coin, final Integer number) {
		final boolean updatable = ZERO < number;
		if (!updatable) {
			return;
		}
		changes.put(coin, number);
		reduce(coin * number);
	}

	@Override
	public String toString() {
		return INSERTED_AMOUNT + COLON + BLANK + money + WON;
	}

	public int getMoney() {
		return money;
	}
}
