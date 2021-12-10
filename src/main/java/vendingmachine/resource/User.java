package vendingmachine.resource;

public class User {
	private static final User user = new User();

	int inputAmount;

	private User() {
		inputAmount = 0;
	}

	public static User getUser() {
		return user;
	}

	public void putMoney(int money) {
		inputAmount += money;
	}
}
