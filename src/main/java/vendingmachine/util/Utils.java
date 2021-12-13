package vendingmachine.util;

public class Utils {
	public static int moneyConverter(String money) {
		return Integer.parseInt(money);
	}

	public static int getMaxRange(int money, int unit) {
		return money/unit;
	}
}
