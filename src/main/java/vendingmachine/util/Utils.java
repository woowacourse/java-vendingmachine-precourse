package vendingmachine.util;

import java.util.regex.Pattern;

public class Utils {
	private static final String NUMBER_ONLY_REGEX = "^[0-9]+$";

	public static int moneyConverter(String money) {
		return Integer.parseInt(money);
	}

	public static boolean isOnlyContainNumber(String money) {

		return !Pattern.matches(NUMBER_ONLY_REGEX, money);
	}
}
