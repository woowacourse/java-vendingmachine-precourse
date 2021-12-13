package vendingmachine.model;

import org.assertj.core.util.Strings;

public class BeverageValidator {
	private static final int COUNT_MIN = 0;
	private static final String COUNT_SMALL_ERROR = "[ERROR] 상품 개수가 너무 적습니다.";
	private static final String NAME_EMPTY_ERROR = "[ERROR] 상품 이름이 비어있습니다.";
	private static final Money PRICE_LOWER_BOUND = Money.from(100);
	private static final String PRICE_LOWER_ERROR = "[ERROR] 상품 가격이 너무 작습니다.";

	private BeverageValidator() {
	}

	public static void validate(String name, Money price, int count) {
		validateName(name);
		validatePrice(price);
		validateCount(count);
	}

	private static void validateName(String name) {
		if (Strings.isNullOrEmpty(name)) {
			throw new IllegalArgumentException(NAME_EMPTY_ERROR);
		}
	}

	private static void validateCount(int count) {
		if (count < COUNT_MIN) {
			throw new IllegalArgumentException(COUNT_SMALL_ERROR);
		}
	}

	private static void validatePrice(Money price) {
		if (!price.isValuableThan(PRICE_LOWER_BOUND)) {
			throw new IllegalArgumentException(PRICE_LOWER_ERROR);
		}
	}
}
