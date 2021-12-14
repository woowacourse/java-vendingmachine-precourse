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

	@Override
	public String toString() {
		return INSERTED_AMOUNT + COLON + BLANK + money + WON;
	}

	public int getMoney() {
		return money;
	}
}
