package vendingmachine;

import static vendingmachine.ValidationUtils.*;

public class UserMoney {

	public static boolean valid(int money) {
		return validUnitMoney(money) && isPositive(money);
	}
}
