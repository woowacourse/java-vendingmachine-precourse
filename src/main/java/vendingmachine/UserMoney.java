package vendingmachine;

import static vendingmachine.ValidationUtils.*;

public class UserMoney {
	private int money;

	public UserMoney(int money) {
		this.money = money;
	}

	public static boolean valid(int money) {
		return validUnitMoney(money) && isPositive(money);
	}

	public void subtractUserMoney(int price) {
		this.money -= price;
	}

	public int getMoney() {
		return this.money;
	}
}
