package vendingmachine.utils;

public class ExceptionUtils {

	private ExceptionUtils() {
	}

	private static final int MINIMUM_NATURAL_NUMBER = 1;
	private static final int MINIMUM_UNIT_OF_MONEY = 10;
	private static final int APPROPRIATE_REMAINDER = 0;
	private static final int MAXIMUM_INT_VALUE = 2147483647;
	private static final String SPACE = " ";
	private static final String REGULAR_EXPRESSION_ONLY_NUMBER = "^[0-9]*$";
	private static final String ERROR_HEADER = "[ERROR] ";
	private static final String SPACE_ERROR_MESSAGE = "공백이 입력되었습니다.";
	private static final String NATURAL_NUMBER_ERROR_MESSAGE = "자연수만 입력 가능합니다.";
	private static final String UNIT_ERROR_MESSAGE = "최소 단위 금액은 10원입니다. 10의 배수로 입력해주세요.";
	private static final String OVER_RANGE_ERROR_MESSAGE = "최대 허용하는 정수값을 초과했습니다.";

	public static void validateMoney(String money) {
		if (!validateSpace(money)) {
			throw new IllegalArgumentException(ERROR_HEADER + SPACE_ERROR_MESSAGE);
		}
		if (!validateNumber(money) && !validatePositiveNumber(money)) {
			throw new IllegalArgumentException(ERROR_HEADER + NATURAL_NUMBER_ERROR_MESSAGE);
		}
		if (!validateMultiplicationOfTen(money)) {
			throw new IllegalArgumentException(ERROR_HEADER + UNIT_ERROR_MESSAGE);
		}
		if (!validateMaxValue(money)) {
			throw new IllegalArgumentException(ERROR_HEADER + OVER_RANGE_ERROR_MESSAGE);
		}
	}

	private static boolean validateSpace(String inputMoney) {
		return (!(inputMoney.contains(SPACE) || inputMoney.isEmpty()));
	}

	private static boolean validateNumber(String inputMoney) {
		return inputMoney.matches(REGULAR_EXPRESSION_ONLY_NUMBER);
	}

	private static boolean validatePositiveNumber(String inputMoney) {
		return Integer.parseInt(inputMoney) >= MINIMUM_NATURAL_NUMBER;
	}

	private static boolean validateMultiplicationOfTen(String inputMoney) {
		return Integer.parseInt(inputMoney) % MINIMUM_UNIT_OF_MONEY == APPROPRIATE_REMAINDER;
	}

	private static boolean validateMaxValue(String inputMoney) {
		return Long.parseLong(inputMoney) <= MAXIMUM_INT_VALUE;
	}
}
