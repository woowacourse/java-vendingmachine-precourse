package model;

public class UserInsertMoneyBox {
	final int money;

	public UserInsertMoneyBox(int userInsertMoney) {
		money = userInsertMoney;
	}

	public int bringMoney() {
		return money;
	}

	public boolean hasEnoughMoney(int minimumProductPrice) {
		if (money < minimumProductPrice) {
			return false;
		}
		return true;
	}
}
