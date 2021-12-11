package vendingmachine.validation;

public class InputValidator {
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String NOT_DIGIT_MESSAGE = "양수의 숫자가 아닌 문자는 입력할 수 없습니다.";
	private static final String NOT_RANGE_MESSAGE = "10원 단위로 입력해주세요.";
	private static final int MOD_NUMBER = 10;

	public boolean isValidChanges(String changes) {
		try {
			validateNumberInput(changes);
			validateNumberInRange(changes);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	private void validateNumberInput(String number) {
		if (number.chars().allMatch(Character::isDigit) == false) {
			throw new IllegalArgumentException(ERROR_MESSAGE + NOT_DIGIT_MESSAGE);
		}
	}

	private void validateNumberInRange(String number) {
		if (number.equals("0") || Integer.parseInt(number) % MOD_NUMBER != 0) {
			throw new IllegalArgumentException(ERROR_MESSAGE + NOT_RANGE_MESSAGE);
		}
	}

}
