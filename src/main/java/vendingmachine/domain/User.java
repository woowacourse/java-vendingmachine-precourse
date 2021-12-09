package vendingmachine.domain;

import static constants.VendingMachineConstants.*;

public class User {
	private int money;

	public User(int money) {
		this.money = money;
	}

	public void buyProduct(int price) {
		money -= price;
	}

	public boolean isEnoughMoney(int price) {
		return money - price >= 0;
	}

	@Override
	public String toString() {
		return USER_INPUT_MONEY_MESSAGE + money + KOR_MONETARY_UNIT;
	}
}
