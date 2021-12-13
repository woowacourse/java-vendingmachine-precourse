package vendingmachine.service.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vendingmachine.view.OutputView;
import vendingmachine.view.messages.ErrorMessage;

public class ItemInputValidator {
	private static List<String> itemDuplicateValidatorList = new ArrayList<>();
	private static final int ITEM_NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int PRICE_DIVISIBLE_BY = 10;
	private static final int QUANTITY_INDEX = 2;
	private static final int QUANTITY_MIN = 1;
	private static final int MINIMUM_PRICE = 100;
	public static final int SIZE_OF_ITEM_LIST = 3;
	public static final int ZERO = 0;
	private static final String START_BRACKET = "[";
	private static final String END_BRACKET = "]";
	public static final String ELEMENT_DELIMITER = ",";

	public boolean validateItemInput(String itemString) {
		try {
			validateBrackets(itemString);
			String itemWithoutBrackets = deleteBrackets(itemString);
			List<String> itemElements = Arrays.asList(itemWithoutBrackets.split(ELEMENT_DELIMITER));
			validateSize(itemElements);
			validatePrice(itemElements);
			validateQuantity(itemElements);
			validateDuplicateItem(itemElements);
		} catch (IllegalArgumentException exception) {
			OutputView.printErrorMessage(exception.getMessage());
			itemDuplicateValidatorList.clear();
			return false;
		}
		return true;
	}

	private void validateBrackets(String itemString) {
		if (!itemString.startsWith(START_BRACKET)) {
			throw new IllegalArgumentException(ErrorMessage.START_BRACKET_EXCEPTION);
		}
		if (!itemString.endsWith(END_BRACKET)) {
			throw new IllegalArgumentException(ErrorMessage.END_BRACKET_EXCEPTION);
		}
	}

	private void validateSize(List<String> itemElements) {
		if (!(itemElements.size() == SIZE_OF_ITEM_LIST)) {
			throw new IllegalArgumentException(ErrorMessage.ITEM_INFO_EXCEPTION);
		}
	}

	private void validatePrice(List<String> itemElements) {
		String priceString = itemElements.get(PRICE_INDEX);
		isPriceDigit(priceString);
		isDivisible(priceString);
		validateMinimumPrice(priceString);
	}

	private void validateQuantity(List<String> itemElements) {
		String quantityString = itemElements.get(QUANTITY_INDEX);
		isQuantityDigit(quantityString);
		isQuantityPositive(quantityString);
	}

	private void validateDuplicateItem(List<String> itemElements) {
		String itemName = itemElements.get(ITEM_NAME_INDEX);
		if (itemDuplicateValidatorList.contains(itemName)) {
			throw new IllegalArgumentException("상품의 이름이 중복되어서는 안됩니다.");
		}
		itemDuplicateValidatorList.add(itemName);
	}

	private void isPriceDigit(String priceString) {
		for (int i = 0; i < priceString.length(); i++) {
			if (!Character.isDigit(priceString.charAt(i))) {
				throw new IllegalArgumentException(ErrorMessage.ITEM_PRICE_CHARACTER_EXCEPTION);
			}
		}
	}

	private void isDivisible(String priceString) {
		if (Integer.parseInt(priceString) % PRICE_DIVISIBLE_BY != ZERO) {
			throw new IllegalArgumentException(ErrorMessage.ITEM_PRICE_DIVISIBLE_EXCEPTION);
		}
	}

	private void validateMinimumPrice(String priceString) {
		if (Integer.parseInt(priceString) < MINIMUM_PRICE) {
			throw new IllegalArgumentException(ErrorMessage.ITEM_PRICE_MINIMUM_EXCEPTION);
		}
	}

	private void isQuantityDigit(String quantityString) {
		for (int i = 0; i < quantityString.length(); i++) {
			if (!Character.isDigit(quantityString.charAt(i))) {
				throw new IllegalArgumentException(ErrorMessage.ITEM_QUANTITY_CHARACTER_EXCEPTION);
			}
		}
	}

	private void isQuantityPositive(String quantityString) {
		if (Integer.parseInt(quantityString) < QUANTITY_MIN) {
			throw new IllegalArgumentException(ErrorMessage.ITEM_QUANTITY_MINIMUM_EXCEPTION);
		}
	}

	public String deleteBrackets(String itemString) {
		return itemString.replaceAll("\\[", "").replaceAll("\\]", "");
	}
}
