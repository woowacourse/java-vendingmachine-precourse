package vendingmachine.validation;

import vendingmachine.Parser;

public class InputValidator {
	public static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String NOT_MERCHANDISEFORM_MESSAGE
		= "상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해주세요";
	private static final String NOT_NAME_LENGTH_IN_RANGE = "이름은 한글자 이상이어야 합니다.";
	private static final NumberInputValidator numberInputValidator = new NumberInputValidator();
	private static final int MIN_NAME_LENGTH = 1;
	private static final int ITEM_INFO_LENGTH = 3;

	public boolean isValidMoney(String amount) {
		try {
			numberInputValidator.validateNumberInput(amount);
			numberInputValidator.validateNonZero(amount);
			numberInputValidator.validateMultipleNumber(amount);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	public boolean isValidMerchandise(String merchandiseList) {
		try {
			validateItemsForm(merchandiseList);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	private void validateItemsForm(String merchandiseList) {
		String[] items = merchandiseList.split(";");
		if (items.length == 0) {
			throw new IllegalArgumentException(ERROR_MESSAGE + NOT_MERCHANDISEFORM_MESSAGE);
		}

		for (String item : items) {
			if (item.length() < 0) {
				throw new IllegalArgumentException(ERROR_MESSAGE + NOT_MERCHANDISEFORM_MESSAGE);
			}
			validateItemForm(item);
		}
	}

	private void validateItemForm(String item) {
		item = item.replace("[", "").replace("]", "");
		String[] elements = item.split(",");
		if (elements.length != ITEM_INFO_LENGTH) {
			throw new IllegalArgumentException(ERROR_MESSAGE + NOT_MERCHANDISEFORM_MESSAGE);
		}
		validateMerchandiseName(elements[Parser.ITEM_NAME_INDEX]);
		validateMerchandisePrice(elements[Parser.ITEM_PRICE_INDEX]);
		validateMerchandiseCount(elements[Parser.ITEM_COUNT_INDEX]);
	}

	private void validateMerchandiseName(String name) {
		if (name.length() < MIN_NAME_LENGTH) {
			throw new IllegalArgumentException(ERROR_MESSAGE + NOT_NAME_LENGTH_IN_RANGE);
		}
	}

	private void validateMerchandisePrice(String price) {
		numberInputValidator.validateNumberInput(price);
		numberInputValidator.validateMultipleNumber(price);
		numberInputValidator.validatePriceOverMin(price);
	}

	private void validateMerchandiseCount(String count) {
		numberInputValidator.validateNumberInput(count);
	}

}
