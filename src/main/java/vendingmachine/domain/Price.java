package vendingmachine.domain;

public class Price {
	private static final int PRICE_ZERO = 0;
	private static final int PRICE_DIVISION_STANDARD = 10;
	private static final String PRICE_INPUT_FIRST_ELEMENT = "0";
	private static final String ERROR_PRICE_NOT_NUMBER = "상품 금액이 숫자가 아닙니다.";
	private static final String ERROR_PRICE_NOT_PATTERN = "상품 금액 앞자리에는 0을 입력할 수 없습니다.";
	private static final String ERROR_PRICE_NOT_TEN_PERCENT_DIVISION = "상품 금액은 10의 단위로 나누어 떨어져야 합니다.";

	public final int price;

	public Price(int price) {
		this.price = price;
	}

	public static Price from(String price) {
		isValidateNumber(price);
		isValidatePricePattern(price);
		isValidatePrice10PercentDivision(price);
		return new Price(Integer.parseInt(price));
	}

	private static void isValidateNumber(String price) {
		try {
			Integer.parseInt(price);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_PRICE_NOT_NUMBER);
		}
	}

	private static void isValidatePricePattern(String price) {
		if (price.startsWith(PRICE_INPUT_FIRST_ELEMENT)) {
			throw new IllegalArgumentException(ERROR_PRICE_NOT_PATTERN);
		}
	}

	private static void isValidatePrice10PercentDivision(String price) {
		if (Integer.parseInt(price) % PRICE_DIVISION_STANDARD != PRICE_ZERO) {
			throw new IllegalArgumentException(ERROR_PRICE_NOT_TEN_PERCENT_DIVISION);
		}
	}
}
