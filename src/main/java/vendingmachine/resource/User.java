package vendingmachine.resource;

public class User {
	private static final User user = new User();

	int money;

	private User() {
		money = 0;
	}

	public static User getUser() {
		return user;
	}

	public void putMoney(int money) {
		this.money += money;
	}

	public int getRemainingMoney() {
		return money;
	}

	public void reduceMoney(int money) {
		this.money -= money;
	}
}
