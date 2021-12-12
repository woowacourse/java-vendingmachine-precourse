package vendingmachine.util;

public class Money {
	public static int setMoney(String moneyStr) {
		int money;
		try {
			money = NumberException.checkMoneyException(moneyStr);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return money;
	}
}
