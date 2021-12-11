package vendingmachine.validator;

public class NumberValidator {
	static final String MSG_NOT_INTEGER_ERROR = "[ERROR] 정수를 입력해야 한다.";

	static public void isInteger(String number) {
		try {
			Integer.parseInt(number.trim());
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(MSG_NOT_INTEGER_ERROR);
		}
	}
}
