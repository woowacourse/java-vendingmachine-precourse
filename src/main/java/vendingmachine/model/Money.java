package vendingmachine.model;

public class Money {

	private int money = 0;

	public Money(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void subtractMoney(int subtraction) {
		money -= subtraction;
	}

	public boolean isMoneyBiggerThanValue(int value) {
		return money >= value;
	}
}
