package vendingmachine.utils;

public class StringUtils {
	// TODO: str 보다 더 좋은 네이밍 고민 필요
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
