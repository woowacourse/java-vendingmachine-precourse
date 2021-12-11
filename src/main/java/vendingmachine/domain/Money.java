package vendingmachine.domain;

public class Money {
	private static final String COLON = ":";
	private static final String INSERTED_REMAINING_AMOUNT = "투입 금액 " + COLON;
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
		return INSERTED_REMAINING_AMOUNT + money + " ";
	}
}
