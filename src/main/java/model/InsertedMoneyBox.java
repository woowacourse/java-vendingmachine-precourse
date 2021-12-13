package model;

public class InsertedMoneyBox {
	private int money;

	public InsertedMoneyBox(int insertedMoney) {
		money = insertedMoney;
	}

	public int getMoney() {
		return money;
	}

	public boolean hasEnoughMoney(int productPrice) {
		return money >= productPrice;
	}

	public void reduceMoney(int productPrice) {
		money -= productPrice;
	}
}
