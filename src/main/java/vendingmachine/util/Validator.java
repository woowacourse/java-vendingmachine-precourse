package vendingmachine.util;

import static vendingmachine.constant.Constant.*;
import static vendingmachine.domain.Coin.*;

public class Validator {

	private static final String VALIDATE_NUMBER_MESSAGE = "[ERROR] 숫자만 입력이 가능합니다.";
	private static final String VALIDATE_NEGATIVE_MESSAGE = "[ERROR] 음수는 입력할 수 없습니다.";

	public void validatePrice(String number) {
		validateNumber(number);
		validateNegative(number);
	}

	public void validateNumber(String number) {
		boolean isNumeric = number.matches(REGEX_EXPRESSION_OF_NUMBER);
		if (!isNumeric) {
			throw new IllegalArgumentException(VALIDATE_NUMBER_MESSAGE);
		}
	}

	public void validateNegative(String number) {
		if (Integer.parseInt(number) < 0) {
			throw new IllegalArgumentException(VALIDATE_NEGATIVE_MESSAGE);
		}
	}

	public void validateCoin(int money) {
		if (money % getMinimumCoinUnit() != 0) {
			throw new IllegalArgumentException(MONEY_SMALLER_THAN_MINIMUM_COIN);
		}
	}

}
