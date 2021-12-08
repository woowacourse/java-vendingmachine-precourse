package vendingmachine.util.validator;

import vendingmachine.util.ErrorMessage;
import vendingmachine.util.InputCondition;

public class ItemValidator {

	public static void validateItemInfo(String input) {
		validateItemInfoFormat(input);
	}

	private static void validateItemInfoFormat(String input) {
		if (!input.matches(InputCondition.MULTIPLE_REGEX)) {
			throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() + ErrorMessage.INVALID_ITEM_INFO_FORMAT);
		}
	}

	public static void validateItemName(String input) {
		validateItemNameFormat(input);
	}

	private static void validateItemNameFormat(String input) {
		if (!input.matches(InputCondition.ITEM_NAME_REGEX)) {
			throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage() + ErrorMessage.INVALID_ITEM_INFO_FORMAT);
		}
	}

}
