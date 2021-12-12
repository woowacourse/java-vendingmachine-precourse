package vendingmachine.utils;

public class Validator {

	public static void validateMoney(int money) {
		if (money <= 0) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_ERROR_MESSAGE);
		}
	}

	public static void validateEmptyMerchandiseName(String merchandiseName) {
		if (merchandiseName.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MERCHANDISE_EMPTY_NAME_ERROR_MESSAGE);
		}
	}

	public static void validateQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_QUANTITY_ERROR_MESSAGE);
		}
	}

	public static void validateInputMerchandise(String merchandiseInformation) {
		if (!merchandiseInformation.contains("[") || !merchandiseInformation.contains("]")) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MERCHANDISE_INPUT_ERROR_MESSAGE);
		}
	}
}
