package vendingmachine.validation;

import vendingmachine.domain.Merchandise;

public class InputValidator {
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String NOT_DIGIT_MESSAGE = "양수의 숫자가 아닌 문자는 입력할 수 없습니다.";
	private static final String NOT_RANGE_MESSAGE = "10원 단위로 입력해주세요.";
	private static final String NOT_MERCHANDISEFORM_MESSAGE
		= "상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해주세요";
	private static final String NOT_NAME_LENGTH_IN_RANGE = "이름은 한글자 이상이어야 합니다.";
	private static final String PRICE_MIN_MESSAGE = "상품 가격은 100원 이상으로 입력해 주세요";
	private static final int MOD_NUMBER = 10;

	public boolean isValidChanges(String changes) {
		try {
			validateNumberInput(changes);
			validateNumberInRange(changes);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	private void validateNumberInput(String number) {
		if (number.chars().allMatch(Character::isDigit) == false) {
			throw new IllegalArgumentException(ERROR_MESSAGE + NOT_DIGIT_MESSAGE);
		}
	}

	private void validateNumberInRange(String number) {
		if (number.equals("0") || Integer.parseInt(number) % MOD_NUMBER != 0) {
			throw new IllegalArgumentException(ERROR_MESSAGE + NOT_RANGE_MESSAGE);
		}
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
		validateNumberInput(price);
		validateNumberInRange(price);
		if(Integer.parseInt(price)<100) {
			throw new IllegalArgumentException(ERROR_MESSAGE + PRICE_MIN_MESSAGE);
		}
	}

	private void validateMerchandiseCount(String count) {
		validateNumberInput(count);
	}

}
