package vendingmachine.util;

import java.util.regex.Pattern;

public class Utils {
	public static int moneyConverter(String money) {
		return Integer.parseInt(money);
	}

	public static boolean isOnlyContainNumber(String money) {
		String numberOnly = "^[0-9]+$";

		return !Pattern.matches(numberOnly, money);
	}
}
