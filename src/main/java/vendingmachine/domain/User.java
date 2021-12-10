package vendingmachine.domain;

import static constants.VendingMachineConstants.*;

public class User {
	private int money;

	public User(int money) {
		this.money = money;
	}

	public void buyProduct(int price) {
		if(!isEnoughMoney(price)){
			throw new IllegalArgumentException(PRODUCT_EXPENSIVE_ERROR);
		}
		money -= price;
	}

	public boolean isEnoughMoney(int price) {
		return money - price >= 0;
	}

	public int getMoney() {
		return money;
	}

	@Override
	public String toString() {
		return USER_INPUT_MONEY_MESSAGE + money + KOR_MONETARY_UNIT;
	}
}
