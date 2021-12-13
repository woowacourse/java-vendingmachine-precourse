package vendingmachine;

/**
 * 필요한 검증을 수행하는 model class
 *
 * @author YJGwon
 * @version 1.1
 * @since 1.0
 */
public class Validator {
	public int stringToInteger(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Error.NOT_NUMBER.getMassage());
		}
	}

	public boolean isBiggerThenMinValue(int number, int minValue) {
		return number >= minValue;
	}

	public boolean isDivisible(int dividend, int divisor) {
		return (dividend % divisor) == 0;
	}

	public boolean isBlank(String string) {
		return string.trim().length() > 0;
	}
}
