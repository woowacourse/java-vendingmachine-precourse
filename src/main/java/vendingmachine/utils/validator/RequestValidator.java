package vendingmachine.utils.validator;

public class RequestValidator {
	private static final String IS_NUMBER_ERROR_MESSAGE = "입력값은 양수여야 한다.";
	private static final String IS_EMPTY_ERROR_MESSAGE = "입력값은 빈 값이면 안된다.";

	public static void isNumber(String request) throws IllegalArgumentException {
		try {
			Integer.parseUnsignedInt(request);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(IS_NUMBER_ERROR_MESSAGE);
		}
	}

	public static void isEmpty(String request) throws IllegalArgumentException {
		if (request.isEmpty()) {
			throw new IllegalArgumentException(IS_EMPTY_ERROR_MESSAGE);
		}
	}
}
