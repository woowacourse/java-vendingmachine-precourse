package vendingmachine;

import static vendingmachine.ValidationUtils.*;

public class UserMoney {
	private int money;

	public UserMoney(int money) {
		this.money = money;
	}

	public static void valid(int money) {
		validUnitMoney(money);
		isPositive(money);
	}

	public void subtractUserMoney(int price) {
		this.money -= price;
	}

	public int getMoney() {
		return this.money;
	}
}
