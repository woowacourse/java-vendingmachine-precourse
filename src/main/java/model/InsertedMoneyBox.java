package model;

public class InsertedMoneyBox {
	private int money;

	public InsertedMoneyBox(int userInsertMoney) {
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
