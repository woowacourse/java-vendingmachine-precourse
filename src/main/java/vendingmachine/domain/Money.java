package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Money {
	private static final String COLON = ":";
	private static final String INSERTED_REMAINING_AMOUNT = "%n투입 금액%s %s원";
	private int money;

	public Money(int money) {
		this.money = money;
	}

	public void pay(int moneyAmount) {
		reduce(moneyAmount);
	}

	public void getMoney() {
		System.out.println(money);
	}

	public boolean payable(int moneyAmount) {
		return moneyAmount <= money;
	}

	public Map<Integer, Integer> makeChanges(Coins coins) {
		Map<Integer, Integer> changes = new LinkedHashMap<>();
		for (Map.Entry<Integer, Integer> coin : coins.findAll().entrySet()) {
			int existentCoinAmount = money / coin.getKey();
			if (0 < existentCoinAmount && existentCoinAmount <= coin.getValue()) {
				changes.put(coin.getKey(), existentCoinAmount);
				reduce(coin.getKey() * existentCoinAmount);
			}
		}
		return changes;
	}

	private void reduce(int moneyAmount) {
		money -= moneyAmount;
	}

	@Override
	public String toString() {
		return String.format(INSERTED_REMAINING_AMOUNT, COLON, money);
	}
}
