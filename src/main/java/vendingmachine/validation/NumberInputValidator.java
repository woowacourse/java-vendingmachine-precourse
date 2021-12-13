package vendingmachine.validation;

public class NumberInputValidator {
	private static final String NOT_DIGIT_MESSAGE = "양수의 숫자가 아닌 문자는 입력할 수 없습니다.";
	private static final String NOT_RANGE_MESSAGE = "10원 단위로 입력해주세요.";
	private static final String PAYMENT_MIN_MESSAGE = "0원 이상이어야 합니다.";
	private static final String PRICE_MIN_MESSAGE = "상품 가격은 100원 이상으로 입력해 주세요";
	private static final int MIN_PRICE = 100;
	private static final int MOD_NUMBER = 10;

	public void validateNumberInput(String number) {
		if (number.chars().allMatch(Character::isDigit) == false) {
			throw new IllegalArgumentException(InputValidator.ERROR_MESSAGE + NOT_DIGIT_MESSAGE);
		}
	}

	public void validateNonZero(String number) {
		if (number.equals("0")) {
			throw new IllegalArgumentException(InputValidator.ERROR_MESSAGE + PAYMENT_MIN_MESSAGE);
		}
	}

	public void validateMultipleNumber(String number) {
		if (Integer.parseInt(number) % MOD_NUMBER != 0) {
			throw new IllegalArgumentException(InputValidator.ERROR_MESSAGE + NOT_RANGE_MESSAGE);
		}
	}

	public void validatePriceOverMin(String number) {
		if (Integer.parseInt(number) < MIN_PRICE) {
			throw new IllegalArgumentException(InputValidator.ERROR_MESSAGE + PRICE_MIN_MESSAGE);
		}
	}
}
