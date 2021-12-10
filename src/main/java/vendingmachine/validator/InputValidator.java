package vendingmachine.validator;

import static vendingmachine.constants.ErrorMessages.*;

import java.util.Arrays;

public class InputValidator {
	private static final InputValidator inputValidator = new InputValidator();

	private InputValidator() {
	}

	public static InputValidator getInputValidator() {
		return inputValidator;
	}

	public boolean checkInitialAmountInputExceptions(String initialAmount) {
		try {
			checkAllInitialAmountInputExceptions(initialAmount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean checkInitialItemsInputExceptions(String items) {
		try {
			checkAllInitialItemsInputExceptions(items);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean checkInputAmountInputExceptions(String inputAmount) {
		try {
			checkAllInputAmountInputExceptions(inputAmount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	private void checkAllInitialAmountInputExceptions(String initialAmount) {
		checkEmptyInputExceptions(initialAmount);
		checkNotNaturalNumberExceptions(initialAmount);
		checkNotMultiplicationOfTenExceptions(initialAmount);
	}

	private void checkAllInitialItemsInputExceptions(String items) {
		checkEmptyInputExceptions(items);
		checkNotSatisfiedInputFormatExceptions(items);
		checkArgumentLackExceptions(items);
		checkPriceNotNaturalNumberExceptions(items);
		checkPriceNotMultiplicationOfTenExceptions(items);
		checkQuantityNotNaturalNumberExceptions(items);
	}

	private void checkAllInputAmountInputExceptions(String inputAmount) {
		checkEmptyInputExceptions(inputAmount);
		checkInputAmountNotNaturalNumberExceptions(inputAmount);
		checkInputAmountNotMultiplicationOfTenExceptions(inputAmount);
	}

	private void checkEmptyInputExceptions(String string) {
		if (string.length() == 0){
			throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
		}
	}

	private void checkNotNaturalNumberExceptions(String string) {
		if (string.chars().anyMatch(number -> !Character.isDigit(number))) {
			throw new IllegalArgumentException(MONEY_NOT_NATURAL_NUMBER_ERROR_MESSAGE);
		}
	}

	private void checkNotMultiplicationOfTenExceptions(String string) {
		int number = Integer.parseInt(string);
		if (number % 10 != 0) {
			throw new IllegalArgumentException(MONEY_NOT_MULTIPLICATION_OF_TEN_ERROR_MESSAGE);
		}
	}

	private void checkNotSatisfiedInputFormatExceptions(String string) {
		long wrongFormatItemCount = Arrays.stream(string.split(";"))
			.filter(item ->
				item.charAt(0) != '[' || item.charAt(item.length() - 1) != ']')
			.count();
		if (wrongFormatItemCount > 0) {
			throw new IllegalArgumentException(NOT_SATISFIED_INPUT_FORMAT_ERROR_MESSAGE);
		}
	}

	private void checkArgumentLackExceptions(String string) {
		if (Arrays.stream(string.split(";"))
			.anyMatch(item -> item.split(",").length != 3)) {
			throw new IllegalArgumentException(ITEM_ARGUMENT_LACK_ERROR_MESSAGE);
		}
	}

	private void checkPriceNotNaturalNumberExceptions(String string) {
		if (Arrays.stream(string.split(";"))
			.map(item -> item.split(",")[1])
			.flatMapToInt(CharSequence::chars)
			.anyMatch(number -> !Character.isDigit(number))) {
			throw new IllegalArgumentException(PRICE_NOT_NATURAL_NUMBER_ERROR_MESSAGE);
		}
	}

	private void checkPriceNotMultiplicationOfTenExceptions(String string) {
		if (Arrays.stream(string.split(";"))
			.map(item -> item.split(",")[1])
			.map(Integer::parseInt)
			.anyMatch(price -> price % 10 != 0)) {
			throw new IllegalArgumentException(PRICE_NOT_MULTIPLICATION_OF_TEN_ERROR_MESSAGE);
		}
	}

	private void checkQuantityNotNaturalNumberExceptions(String string) {
		if (Arrays.stream(string.split(";"))
			.map(item -> item.split(",")[2].replace("]", ""))
			.flatMapToInt(CharSequence::chars)
			.anyMatch(number -> !Character.isDigit(number))) {
			throw new IllegalArgumentException(QUANTITY_NOT_NATURAL_NUMBER_ERROR_MESSAGE);
		}
	}

	private void checkInputAmountNotNaturalNumberExceptions(String string) {
		if (string.chars().anyMatch(number -> !Character.isDigit(number))) {
			throw new IllegalArgumentException(INPUT_AMOUNT_NOT_NATURAL_NUMBER_ERROR_MESSAGE);
		}
	}

	private void checkInputAmountNotMultiplicationOfTenExceptions(String string) {
		int number = Integer.parseInt(string);
		if (number % 10 != 0) {
			throw new IllegalArgumentException(INPUT_AMOUNT_NOT_MULTIPLICATION_OF_TEN_ERROR_MESSAGE);
		}
	}
}
