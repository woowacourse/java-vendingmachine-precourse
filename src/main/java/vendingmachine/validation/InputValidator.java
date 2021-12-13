package vendingmachine.validation;

import vendingmachine.domain.Merchandise;

public class InputValidator {
	public static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String NOT_MERCHANDISEFORM_MESSAGE
		= "상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해주세요";
	private static final String NOT_NAME_LENGTH_IN_RANGE = "이름은 한글자 이상이어야 합니다.";
	private static final NumberInputValidator numberInputValidator = new NumberInputValidator();

	public boolean isValidChanges(String changes) {
		try {
			numberInputValidator.validateNumberInput(changes);
			numberInputValidator.validateNonZero(changes);
			numberInputValidator.validateMultipleNumber(changes);
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

	public boolean isValidPayment(String payment) {
		try {
			numberInputValidator.validateNumberInput(payment);
			numberInputValidator.validateMultipleNumber(payment);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	private void validateItemsForm(String merchandiseList) {
		String[] items = merchandiseList.split(";");
		for (String item : items) {
			if (item.length() == 0) {
				throw new IllegalArgumentException(ERROR_MESSAGE + NOT_MERCHANDISEFORM_MESSAGE);
			}
			validateItemForm(item);
		}
	}

	private void validateItemForm(String item) {
		item = item.replace("[", "").replace("]", "");
		String[] elements = item.split(",");
		if (elements.length != 3) {
			throw new IllegalArgumentException(ERROR_MESSAGE + NOT_MERCHANDISEFORM_MESSAGE);
		}
		validateMerchandiseName(elements[Merchandise.MERCHANDISE_NAME_INDEX]);
		validateMerchandisePrice(elements[Merchandise.MERCHANDISE_PRICE_INDEX]);
		validateMerchandiseCount(elements[Merchandise.MERCHANDISE_COUNT_INDEX]);
	}

	private void validateMerchandiseName(String name) {
		if (name.length() == 0) {
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
