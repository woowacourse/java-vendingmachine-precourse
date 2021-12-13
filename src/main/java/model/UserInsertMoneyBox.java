package model;

public class UserInsertMoneyBox {
	private int money;

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

	public void reduceMoney(int soldProductPrice) {
		money -= soldProductPrice;
	}
}
