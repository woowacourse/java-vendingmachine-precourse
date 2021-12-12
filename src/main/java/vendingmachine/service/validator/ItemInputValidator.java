package vendingmachine.service.validator;

import java.util.Arrays;
import java.util.List;

import vendingmachine.view.OutputView;

public class ItemInputValidator {
	private static final int PRICE_INDEX = 1;
	private static final int PRICE_DIVISIBLE_BY = 10;
	private static final int QUANTITY_INDEX = 2;
	private static final int QUANTITY_MIN = 1;
	private static final int MINIMUM_PRICE = 100;

	public boolean validateItemInput(String itemString) {
		try {
			validateBrackets(itemString);
			String itemWithoutBrackets = deleteBrackets(itemString);
			List<String> itemElements = Arrays.asList(itemWithoutBrackets.split(","));
			validateSize(itemElements);
			validatePrice(itemElements);
			validateQuantity(itemElements);
		} catch (IllegalArgumentException exception) {
			OutputView.printErrorMessage(exception.getMessage());
			return false;
		}
		return true;
	}

	private void validateBrackets(String itemString) {
		if (!itemString.startsWith("[")) {
			throw new IllegalArgumentException("각 상품의 입력은 대괄호로 시작해야 합니다.");
		}
		if (!itemString.endsWith("]")) {
			throw new IllegalArgumentException("각 상품의 입력은 대괄호로 끝나야 합니다.");
		}
	}

	private void validateSize(List<String> itemElements) {
		if (!(itemElements.size() == 3)) {
			throw new IllegalArgumentException("상품의 정보는 [상품,가격,수량]으로 입력해야 합니다.");
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

	private void isPriceDigit(String priceString) {
		for (int i = 0; i < priceString.length(); i++) {
			if (!Character.isDigit(priceString.charAt(i))) {
				throw new IllegalArgumentException("상품의 가격은 숫자로 입력되어야 합니다.");
			}
		}
	}

	private void isDivisible(String priceString) {
		if (Integer.parseInt(priceString) % PRICE_DIVISIBLE_BY != 0) {
			throw new IllegalArgumentException("상품의 가격은 10으로 나누어 떨어져야 합니다.");
		}
	}

	private void validateMinimumPrice(String priceString) {
		if (Integer.parseInt(priceString) < MINIMUM_PRICE) {
			throw new IllegalArgumentException("상품의 가격은 100원 이상이어야 합니다.");
		}
	}

	private void isQuantityDigit(String quantityString) {
		for (int i = 0; i < quantityString.length(); i++) {
			if (!Character.isDigit(quantityString.charAt(i))) {
				throw new IllegalArgumentException("상품의 수량은 숫자로 입력되어야 합니다.");
			}
		}
	}

	private void isQuantityPositive(String quantityString) {
		if (Integer.parseInt(quantityString) < QUANTITY_MIN) {
			throw new IllegalArgumentException("상품의 수량은 1 이상이어야 합니다.");
		}
	}

	public String deleteBrackets(String itemString) {
		return itemString.replaceAll("\\[", "").replaceAll("\\]", "");
	}
}
