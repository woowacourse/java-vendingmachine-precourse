package vendingmachine.domain.user;

public class Balance {

	private int money = 0;

	public void deposit(int money) {
		this.money += money;
	}

	public void withdraw(int money) {
		this.money -= money;
	}

	public int getMoney() {
		return this.money;
	}

	public boolean isNotLessThan(int money) {
		return (this.money >= money);
	}

}
