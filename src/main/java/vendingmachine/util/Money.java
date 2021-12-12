package vendingmachine.util;

public class Money {
	public static int setMoney(String moneyStr) {
		int money;
		money = NumberException.checkMoneyException(moneyStr);
		return money;
	}
}
