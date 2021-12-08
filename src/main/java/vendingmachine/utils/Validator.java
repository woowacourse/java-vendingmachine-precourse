package vendingmachine.utils;

public class Validator {
	public static String INVALIDATE_ZERO_UNDER_NUMBER_ERROR_MESSAGE = "금액은 0원 이상 입력해야한다.";

	public static void validateMoney(int money) {
		if (money <= 0) {
			throw new IllegalArgumentException(INVALIDATE_ZERO_UNDER_NUMBER_ERROR_MESSAGE);
		}
	}
}
