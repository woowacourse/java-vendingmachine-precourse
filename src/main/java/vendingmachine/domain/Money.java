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
		for (Map.Entry<Integer, Integer> coin : coins.findRestCoins().entrySet()) {
			int number = getAvailableChangeNumber(coin.getKey(), coin.getValue(), money);
			changes.put(coin.getKey(), number);
			reduce(coin.getKey() * number);
		}
		return changes;
	}

	private int getAvailableChangeNumber(int coin, int number, int money){
		if (coin * number > money){ // 동전 총액 > 투입 금액인 경우 (example: 100원 * 3 (300원) > 투입금액 200원)
			return money / coin;
		}
		return number;
	}

	private void reduce(int moneyAmount) {
		money -= moneyAmount;
	}

	@Override
	public String toString() {
		return String.format(INSERTED_REMAINING_AMOUNT, COLON, money);
	}
}
