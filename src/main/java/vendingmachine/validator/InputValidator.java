package vendingmachine.validator;

import static vendingmachine.constant.ErrorMessage.*;

import java.util.regex.Pattern;

import vendingmachine.repository.ItemRepository;

public class InputValidator {

	public static void validateMachineMoney(String input) {
		isDigit(input);
		isPositive(input);
		isCorrectUnit(input);
	}

	private static void isDigit(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_NOT_NUMBER);
		}
	}

	private static void isPositive(String input) {
		int intInput = Integer.parseInt(input);
		if (intInput < 0) {
			throw new IllegalArgumentException(ERROR_NOT_POSITIVE);
		}
	}

	private static void isCorrectUnit(String input) {
		int intInput = Integer.parseInt(input);
		if (intInput % 10 != 0) {
			throw new IllegalArgumentException(ERROR_NOT_CORRECT_UNIT);
		}
	}

	public static void validateItems(String input) {
		isCorrectBracket(input);
	}

	public static void validateItem(String input) {
		isCorrectBracket(input);
		String regExp = "^\\[[\\w가-힣]*,\\d+,\\d+\\]$";
		boolean matches = Pattern.matches(regExp, input);
		if (!matches) {
			throw new IllegalArgumentException(ERROR_INVALID_ITEM_FORMAT);
		}
	}

	private static void isCorrectBracket(String input) {
		String regExp = "^\\[.*\\]$";
		boolean matches = Pattern.matches(regExp, input);
		if (!matches) {
			throw new IllegalArgumentException(ERROR_INVALID_BRACKETS);
		}
	}

	public static void validateMoneyToBuy(String input) {
		isDigit(input);
		isPositive(input);
		isCorrectUnit(input);
	}

	public static void validateExistItem(String input) {
		boolean exist = ItemRepository.existItemByName(input);
		if (!exist) {
			throw new IllegalArgumentException(ERROR_NON_EXISTS_ITEM);
		}
	}
}
