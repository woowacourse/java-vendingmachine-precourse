package vendingmachine.domain;

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

	public int getRemainingMoney() {
		return money;
	}

	private void reduce(int moneyAmount) {
		money -= moneyAmount;
	}

	@Override
	public String toString() {
		return String.format(INSERTED_REMAINING_AMOUNT, COLON, money);
	}
}
