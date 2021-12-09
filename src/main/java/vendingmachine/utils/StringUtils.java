package vendingmachine.utils;

public class StringUtils {
	private final static int NATURAL_NUMBER_STANDARD = 0;

	// TODO: str 보다 더 좋은 네이밍 고민 필요
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isNaturalNumber(int number) {
		return number > NATURAL_NUMBER_STANDARD;
	}
}
