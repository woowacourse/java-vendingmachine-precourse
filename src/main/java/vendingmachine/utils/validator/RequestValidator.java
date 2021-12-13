package vendingmachine.utils.validator;

public class RequestValidator {
	private static final String REGEX = "\\[[a-zA-Z0-9가-힣]+,\\d{3,}+,\\d+]";

	private static final String IS_NUMBER_ERROR_MESSAGE = "입력값은 양수여야 한다.";
	private static final String IS_EMPTY_ERROR_MESSAGE = "입력값은 빈 값이면 안된다.";
	private static final String IS_MATCH_REGEX_TO_PRODUCT_ERROR_MESSAGE = "상품 입력 정규식에 맞아야 한다.";

	public static void isNumber(String request) throws IllegalArgumentException {
		try {
			Integer.parseUnsignedInt(request);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(IS_NUMBER_ERROR_MESSAGE);
		}
	}

	public static void isEmpty(String request) throws IllegalArgumentException {
		if (request.isEmpty()) {
			throw new IllegalArgumentException(IS_EMPTY_ERROR_MESSAGE);
		}
	}

	public static void isMatchRegexToProducts(String[] requests) throws IllegalArgumentException {
		for (String request : requests) {
			isMatchRegexToProduct(request);
		}
	}

	public static void isMatchRegexToProduct(String request) throws IllegalArgumentException {
		if (!request.matches(REGEX)) {
			throw new IllegalArgumentException(IS_MATCH_REGEX_TO_PRODUCT_ERROR_MESSAGE);
		}
	}
}
