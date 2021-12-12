package vendingmachine;

public class Validator {

	private static final String ERROR_MSG_NOT_NUMERIC = "[ERROR] 가격, 금액, 수량은 숫자만 입력할 수 있습니다.";
	private static final String ERROR_MSG_LESS_THAN_COIN_MIN = "[ERROR] 입력 값은 10보다 커야합니다.";
	private static final String ERROR_MSG_LESS_THAN_PRODUCT_MIN = "[ERROR] 상품 가격은 10보다 커야합니다.";
	private static final String ERROR_MSG_LESS_THAN_ZERO = "[ERROR] 수량은 0보다 커야합니다.";
	private static final String ERROR_MSG_MULTIPLE_OF_TEN = "[ERROR] 금액, 상품 가격은 10으로 나누어떨어져야 합니다.";
	private static final String ERROR_MSG_NULL = "[ERROR] 입력 값은 공백이 될 수 없습니다.";
	private static final String ERROR_MSG_PRODUCT_THREE_INFO = "[ERROR] 상품 정보는 [상품명,가격,수량]으로 이뤄져야 합니다.";
	private static final int MINIMUM_OF_COIN_AMOUNT = 10;
	private static final int ZERO = 0;

	public static void isNumeric(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception e) {
			throw new IllegalArgumentException(ERROR_MSG_NOT_NUMERIC);
		}
	}

	public static void coinMinimumCheck(String input) {
		if (Integer.parseInt(input) < MINIMUM_OF_COIN_AMOUNT) {
			throw new IllegalArgumentException(ERROR_MSG_LESS_THAN_COIN_MIN);
		}
	}

	public static void multipleOfTen(String input) {
		if (Integer.parseInt(input) % MINIMUM_OF_COIN_AMOUNT > ZERO) {
			throw new IllegalArgumentException(ERROR_MSG_MULTIPLE_OF_TEN);
		}
	}

	public static void hasNullInfo(String[] input) {
		if (input.length != 3) {
			throw new IllegalArgumentException(ERROR_MSG_PRODUCT_THREE_INFO);
		}
	}

	public static void isNull(String input) {
		if (input.trim().isEmpty()) {
			throw new IllegalArgumentException(ERROR_MSG_NULL);
		}
	}

	public static void isBiggerThanHundred(String input) {
		if (Integer.parseInt(input) < 100) {
			throw new IllegalArgumentException(ERROR_MSG_LESS_THAN_PRODUCT_MIN);
		}
	}

	public static void isBiggerThanZero(String input) {
		if (Integer.parseInt(input) <= 0) {
			throw new IllegalArgumentException(ERROR_MSG_LESS_THAN_ZERO);
		}
	}

	public static void productInput(String input) {
		String[] splitProdcutInfo = input.split(",");
		hasNullInfo(splitProdcutInfo);
		for (String productInfo : splitProdcutInfo) {
			isNull(productInfo);
		}
		isNumeric(splitProdcutInfo[1]);
		isBiggerThanHundred(splitProdcutInfo[1]);
		multipleOfTen(splitProdcutInfo[1]);
		isBiggerThanZero(splitProdcutInfo[2]);
	}
}
