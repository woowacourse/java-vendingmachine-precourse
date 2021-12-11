package vendingmachine.product;

public class ProductValidator {
	private static final String ERROR_NAME_EMPTY = "상품명은 공백일 수 없습니다.";
	private static final String ERROR_PRICE_NOT_INTEGER = "상품 가격은 숫자만 입력이 가능합니다.";
	private static final String ERROR_PRICE_RANGE = "상품 가격은 100원 이상이어야 합니다.";
	private static final String ERROR_PRICE_DIVISIBLE = "자판기가 보유하는 금액은 10원으로 나누어떨어져야 합니다.";
	private static final String ERROR_QUANTITY_NOT_INTEGER = "상품 수량은 숫자만 입력이 가능합니다.";
	private static final String ERROR_QUANTITY_RANGE = "상품 수량은 0보다 커야 합니다.";
	private static final String EMPTY = "";
	private static final int ZERO = 0;
	private static final int MINIMUM_PRICE = 100;
	private static final int MINIMUM_DIVISIBLE_NUMBER = 10;

	public void validate(String name, String price, String quantity) {
		validateName(name);
		validatePrice(price);
		validateQuantity(quantity);
	}

	private void validateName(String name) {
		validateEmptyName(name);
	}

	private void validateEmptyName(String name) {
		if (name.equals(EMPTY)) {
			throw new IllegalArgumentException(ERROR_NAME_EMPTY);
		}
	}

	private void validatePrice(String price) {
		validatePriceInteger(price);
		validatePriceMinimum(Integer.parseInt(price));
		validatePriceDivisible(Integer.parseInt(price));
	}

	private void validatePriceInteger(String price) {
		try {
			Integer.parseInt(price);
		} catch (IllegalArgumentException illegalArgumentException) {
			throw new IllegalArgumentException(ERROR_PRICE_NOT_INTEGER);
		}
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
		validateQuantityInteger(quantity);
		validateQuantityRange(Integer.parseInt(quantity));
	}

	private void validateQuantityInteger(String quantity) {
		try {
			Integer.parseInt(quantity);
		} catch (IllegalArgumentException illegalArgumentException) {
			throw new IllegalArgumentException(ERROR_QUANTITY_NOT_INTEGER);
		}
	}

	private void validateQuantityRange(int quantity) {
		if (quantity <= ZERO) {
			throw new IllegalArgumentException(ERROR_QUANTITY_RANGE);
		}
	}
}
