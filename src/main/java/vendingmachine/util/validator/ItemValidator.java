package vendingmachine.util.validator;

import vendingmachine.util.ErrorMessage;
import vendingmachine.util.InputCondition;
import vendingmachine.util.Symbol;

public class ItemValidator {

	public static void validateItemInfo(String input) {
		validateItemInfoFormat(input);
		validateItemPrice(input);
	}

	private static void validateItemInfoFormat(String input) {
		if (!input.matches(InputCondition.MULTIPLE_REGEX)) {
			throw new IllegalArgumentException(
				ErrorMessage.ERROR.getMessage() + ErrorMessage.INVALID_ITEM_INFO_FORMAT + Symbol.MEW_LINE);
		}
	}

	private static void validateItemPrice(String input) {
		String[] itemInfos = input.split(Symbol.SEMICOLON);
		for (String itemInfo : itemInfos) {
			String[] info = itemInfo.split(Symbol.COMMA);
			int price = Integer.parseInt(info[1]);
			if (price < InputCondition.MIN_MONEY_AMOUNT || price % InputCondition.MIN_MONEY_UNIT != InputCondition.ZERO) {
				throw new IllegalArgumentException(
					ErrorMessage.ERROR.getMessage() + ErrorMessage.INVALID_ITEM_PRICE + Symbol.MEW_LINE);
			}
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
