package vendingmachine.model.validator;

public class MoneyValidator {

	public static final String IS_ALL_DIGIT_ERROR_MESSAGE = "[ERROR] 0과 자연수만 입력 가능합니다.";
	public static final String IS_MONEY_KEEP_MIN_UNIT_ERROR_MESSAGE = "[ERROR] 금액의 최소단위는 10원 입니다.";
	public static final int MIN_UNIT_OF_MONEY = 10;

	public boolean validate(String input) {
		try {
			isAllDigit(input);
			isMoneyKeepMinUnit(input);
			return false;
		} catch (IllegalArgumentException illegalArgumentException) {
			return true;
		}
	}

	private void isAllDigit(String input) throws IllegalArgumentException {
		for (char c : input.toCharArray()) {
			if (!Character.isDigit(c)) {
				System.out.println(IS_ALL_DIGIT_ERROR_MESSAGE);
				throw new IllegalArgumentException();
			}
		}
	}

	private void isMoneyKeepMinUnit(String input) {
		if (Integer.parseInt(input) % MIN_UNIT_OF_MONEY != 0) {
			System.out.println(IS_MONEY_KEEP_MIN_UNIT_ERROR_MESSAGE);
			throw new IllegalArgumentException();
		}
	}
}
