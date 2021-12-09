package vendingmachine;

/**
 * 사용자의 입력값에 대한 검증을 수행하는 model class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class Validator {
	private static final String NOT_NUMBER_ERROR = "숫자로만 입력해야 합니다.";
	private static final String CAN_NOT_BE_DIVIDED_BY_10_ERROR = "10원 단위로 입력해야 합니다.";
	private static final String MINUS_ERROR = "음수는 입력할 수 없습니다.";

	public int validateAmountInput(String input) {
		int amount = stringToInteger(input);
		checkMinus(amount);
		checkUnit(amount);
		return amount;
	}

	private int stringToInteger(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NOT_NUMBER_ERROR);
		}
	}

	private void checkMinus(int number) {
		if (number >= 0) {
			return;
		}
		throw new IllegalArgumentException(MINUS_ERROR);
	}

	private void checkUnit(int number) {
		if (number%10 == 0) {
			return;
		}
		throw new IllegalArgumentException(CAN_NOT_BE_DIVIDED_BY_10_ERROR);
	}
}
