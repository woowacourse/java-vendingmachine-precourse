package vendingmachine.validator;

import static vendingmachine.constants.ErrorMessages.*;
import static vendingmachine.constants.ProgramConstants.*;

import java.util.Arrays;
import java.util.stream.Stream;

public class InputValidator {
	private static final InputValidator inputValidator = new InputValidator();

	private InputValidator() {}

	public static InputValidator getInputValidator() {
		return inputValidator;
	}

	public void checkAllInitialAmountInputExceptions(String initialAmount) {
		checkEmptyInputExceptions(initialAmount);
		checkNotNaturalNumberExceptions(initialAmount);
		checkNotMultiplicationOfMinimumCoinTypeExceptions(initialAmount);
	}

	public void checkAllInitialItemsInputExceptions(String items) {
		checkEmptyInputExceptions(items);
		checkNotSatisfiedInputFormatExceptions(items);
		checkArgumentLackExceptions(items);
		checkPriceNotNaturalNumberExceptions(items);
		checkPriceNotMultiplicationOfMinimumCoinTypeExceptions(items);
		checkPriceUnderMinimumItemPriceExceptions(items);
		checkStockNotNaturalNumberExceptions(items);
	}

	public void checkAllInputAmountInputExceptions(String inputAmount) {
		checkEmptyInputExceptions(inputAmount);
		checkInputAmountNotNaturalNumberExceptions(inputAmount);
		checkInputAmountNotMultiplicationOfMinimumCoinTypeExceptions(inputAmount);
	}

	private void checkEmptyInputExceptions(String string) {
		if (string.length() == 0) {
			throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
		}
	}

	private void checkNotNaturalNumberExceptions(String string) {
		if (string.chars().anyMatch(number -> !Character.isDigit(number))) {
			throw new IllegalArgumentException(MONEY_NOT_NATURAL_NUMBER_ERROR_MESSAGE);
		}
	}

	private void checkNotMultiplicationOfMinimumCoinTypeExceptions(String string) {
		int number = Integer.parseInt(string);
		if (number % MINIMUM_COIN_TYPE != 0) {
			throw new IllegalArgumentException(MONEY_NOT_MULTIPLICATION_OF_MINIMUM_COIN_TYPE_ERROR_MESSAGE);
		}
	}

	private void checkNotSatisfiedInputFormatExceptions(String string) {
		long wrongFormatItemCount = Arrays.stream(string.split(ITEMS_SPLITTER))
				.filter(item -> item.charAt(0) != ONE_ITEM_INPUT_START_CHAR
						|| item.charAt(item.length() - 1) != ONE_ITEM_INPUT_END_CHAR)
				.count();
		if (wrongFormatItemCount > 0) {
			throw new IllegalArgumentException(NOT_SATISFIED_INPUT_FORMAT_ERROR_MESSAGE);
		}
	}

	private void checkArgumentLackExceptions(String string) {
		if (Arrays.stream(string.split(ITEMS_SPLITTER))
				.anyMatch(item -> item.split(ITEM_ELEMENT_SPLITTER).length != ITEM_ELEMENT_LENGTH)) {
			throw new IllegalArgumentException(ITEM_ARGUMENT_LACK_ERROR_MESSAGE);
		}
	}

	private void checkPriceNotNaturalNumberExceptions(String string) {
		if (isNotNaturalNumber(string, PRICE_INDEX)) {
			throw new IllegalArgumentException(PRICE_NOT_NATURAL_NUMBER_ERROR_MESSAGE);
		}
	}

	private void checkPriceNotMultiplicationOfMinimumCoinTypeExceptions(String string) {
		if (getElementIntegerStream(string, PRICE_INDEX)
				.anyMatch(price -> price % MINIMUM_COIN_TYPE != 0)) {
			throw new IllegalArgumentException(PRICE_NOT_MULTIPLICATION_OF_MINIMUM_COIN_TYPE_ERROR_MESSAGE);
		}
	}

	private void checkPriceUnderMinimumItemPriceExceptions(String string) {
		if (getElementIntegerStream(string, PRICE_INDEX)
				.anyMatch(price -> price < MINIMUM_ITEM_PRICE)) {
			throw new IllegalArgumentException(PRICE_UNDER_MINIMUM_ITEM_PRICE_ERROR_MESSAGE);
		}
	}

	private void checkStockNotNaturalNumberExceptions(String string) {
		if (isNotNaturalNumber(string, STOCK_INDEX)) {
			throw new IllegalArgumentException(STOCK_NOT_NATURAL_NUMBER_ERROR_MESSAGE);
		}
	}

	private void checkInputAmountNotNaturalNumberExceptions(String string) {
		if (string.chars().anyMatch(number -> !Character.isDigit(number))) {
			throw new IllegalArgumentException(INPUT_AMOUNT_NOT_NATURAL_NUMBER_ERROR_MESSAGE);
		}
	}

	private void checkInputAmountNotMultiplicationOfMinimumCoinTypeExceptions(String string) {
		int number = Integer.parseInt(string);
		if (number % MINIMUM_COIN_TYPE != 0) {
			throw new IllegalArgumentException(INPUT_AMOUNT_NOT_MULTIPLICATION_OF_MINIMUM_COIN_TYPE_ERROR_MESSAGE);
		}
	}

	private boolean isNotNaturalNumber(String string, int elementIndex) {
		return !Arrays.stream(string.split(ITEMS_SPLITTER))
				.map(item -> item.substring(1, item.length() - 1))
				.map(item -> item.split(ITEM_ELEMENT_SPLITTER)[elementIndex])
				.flatMapToInt(CharSequence::chars)
				.allMatch(Character::isDigit);
	}

	private Stream<Integer> getElementIntegerStream(String string, int elementIndex) {
		return Arrays.stream(string.split(ITEMS_SPLITTER))
				.map(item -> item.substring(1, item.length() - 2))
				.map(item -> item.split(ITEM_ELEMENT_SPLITTER)[elementIndex])
				.map(Integer::parseInt);
	}
}
