package vendingmachine.model;

import vendingmachine.resource.User;

public class UserModel {
	private static final UserModel userModel = new UserModel();

	private final User user;

	private UserModel() {
		user = User.getUser();
	}

	public static UserModel getUserModel() {
		return userModel;
	}

	public void putMoney(String money) {
		user.putMoney(Integer.parseInt(money));
	}

	public int getRemainingMoney() {
		return user.getRemainingMoney();
	}

	public void reduceMoney(int money) {
		user.reduceMoney(money);
	}
}
