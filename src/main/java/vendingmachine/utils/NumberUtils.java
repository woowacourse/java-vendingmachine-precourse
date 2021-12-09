package vendingmachine.utils;

public class NumberUtils {
	private final static int NATURAL_NUMBER_STANDARD = 0;
	private static final int REMAINDER = 0;

	public static boolean isNaturalNumber(int number) {
		return number > NATURAL_NUMBER_STANDARD;
	}

	public static boolean isMultipleOf(int target, int multiple) {
		return target % multiple != REMAINDER;
	}

}
