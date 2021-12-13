package vendingmachine.util.validator;

import vendingmachine.util.parser.ItemParser;

public class ItemValidator extends Validator {
	private static final String SEMI_COLON = ";";
	private static final String COMMA = ",";
	private static final int ITEM_INFO_LENGTH = 3;

	public static void isRightItemInput(String input) throws IllegalArgumentException {
		isEmpty(input);
		isRightItems(input);
	}

	private static void isRightItems(String input) {
		String[] items = input.split(SEMI_COLON);
		for (String item : items) {
			isRightItem(item);
		}
	}

	private static void isRightItem(String item) {
		isContainsBracketAndThrowException(item, item.length());
		item = ItemParser.removeBigBracket(item);
		String[] itemInfos = item.split(COMMA);
		isContainsAllItemInfosAndThrowException(itemInfos);
		isRightPrice(itemInfos[1]);
		isRightQuantity(itemInfos[2]);
	}

	private static void isRightQuantity(String quantity) {
		try {
			isNumber(quantity);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("[ERROR] 수량에 숫자를 입력해주세요.");
		}
	}

	private static void isRightPrice(String price) {
		try {
			isNumber(price);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("[ERROR] 가격에 숫자를 입력해주세요.");
		}
	}

	private static void isContainsAllItemInfosAndThrowException(String[] itemInfos) {
		if (!isContainsAllItemInfos(itemInfos)) {
			throw new IllegalArgumentException("[ERROR] 상품 정보를 올바르게 입력해주세요.");
		}
	}

	private static boolean isContainsAllItemInfos(String[] itemInfos) {
		return itemInfos.length == ITEM_INFO_LENGTH;
	}

	private static void isContainsBracketAndThrowException(String item, int length) {
		if (!isContainsBracket(item, length)) {
			throw new IllegalArgumentException("[ERROR] 상품 정보를 올바르게 입력해주세요.");
		}
	}

	private static boolean isContainsBracket(String item, int length) {
		return item.indexOf('[') == 0 && item.lastIndexOf(']') == length - 1;
	}
}
