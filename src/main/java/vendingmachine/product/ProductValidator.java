package vendingmachine.product;

public class ProductValidator {
	private static final String ERROR_NAME_CONTAIN_SPACE = "상품명은 공백을 포함할 수 없습니다.";
	private static final String ERROR_NAME_LENGTH = "상품명은 30자 이하이어야 합니다.";
	private static final String ERROR_NOT_ONLY_NUMBERS = "상품 가격과 수량은 숫자만 입력이 가능합니다.";
	private static final String ERROR_INTEGER_RANGE = "상품 가격과 수량은 20억 이하만 가능합니다.";
	private static final String ERROR_PRICE_RANGE = "상품 가격은 100원 이상이어야 합니다.";
	private static final String ERROR_PRICE_DIVISIBLE = "상품 가격은 10원으로 나누어떨어져야 합니다.";
	private static final String ERROR_QUANTITY_RANGE = "상품 수량은 0보다 커야 합니다.";
	private static final String SPACE = " ";
	private static final int MAXIMUM_INTEGER_RANGE = 2000000000;
	private static final int MAXIMUM_NAME_LENGTH = 30;
	private static final int ZERO = 0;
	private static final int MINIMUM_PRICE = 100;
	private static final int MINIMUM_DIVISIBLE_NUMBER = 10;

	public void validate(String name, String price, String quantity) {
		validateName(name);
		validatePrice(price);
		validateQuantity(quantity);
	}

	private void validateName(String name) {
		validateContainSpace(name);
		validateLength(name);
	}

	private void validateContainSpace(String name) {
		if (name.contains(SPACE)) {
			throw new IllegalArgumentException(ERROR_NAME_CONTAIN_SPACE);
		}
	}

	private void validateLength(String name) {
		if (name.length() > MAXIMUM_NAME_LENGTH) {
			throw new IllegalArgumentException(ERROR_NAME_LENGTH);
		}
	}

	private void validateOnlyNumbers(String input) {
		if (input.chars().anyMatch(each -> !Character.isDigit(each))) {
			throw new IllegalArgumentException(ERROR_NOT_ONLY_NUMBERS);
		}
	}

	private void validateIntegerRange(String input) {
		try {
			if (Integer.parseInt(input) > MAXIMUM_INTEGER_RANGE) {
				throw new IllegalArgumentException(ERROR_INTEGER_RANGE);
			}
		} catch (IllegalArgumentException illegalArgumentException) {
			throw new IllegalArgumentException(ERROR_INTEGER_RANGE);
		}
	}

	private void validatePrice(String price) {
		validateOnlyNumbers(price);
		validateIntegerRange(price);
		validatePriceMinimum(Integer.parseInt(price));
		validatePriceDivisible(Integer.parseInt(price));
	}

	private void validatePriceMinimum(int price) {
		if (price < MINIMUM_PRICE) {
			throw new IllegalArgumentException(ERROR_PRICE_RANGE);
		}
	}

	private void validatePriceDivisible(int price) {
		if (Math.floorMod(price, MINIMUM_DIVISIBLE_NUMBER) != ZERO) {
			throw new IllegalArgumentException(ERROR_PRICE_DIVISIBLE);
		}
	}

	private void validateQuantity(String quantity) {
		validateOnlyNumbers(quantity);
		validateIntegerRange(quantity);
		validateQuantityRange(Integer.parseInt(quantity));
	}

	private void validateQuantityRange(int quantity) {
		if (quantity <= ZERO) {
			throw new IllegalArgumentException(ERROR_QUANTITY_RANGE);
		}
	}
}
