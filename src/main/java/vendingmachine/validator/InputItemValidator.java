package vendingmachine.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputItemValidator {
	private static final String INPUT_ITEM_PATTERN = "^(\\[([a-zA-Z가-힣]+,[0-9]+,[0-9]+)\\])(\\;\\[([a-zA-Z가-힣]+,[0-9]+,[0-9]+)\\])*"; //([a-zA-Z],[0-9],[0-9])
	private static final String INPUT_ITEM_SPLIT_REGEX = ";";
	private final static String REPLACE_TARGET_LEFT = "[";
	private final static String REPLACE_TARGET_RIGHT = "]";
	private final static String SPLIT_REGEX = ",";
	private final static int MIN_PRICE = 100;
	private final static int DIVIDE_BY_10 = 10;
	private final static int PRICE_INDEX = 1;
	private final static int NAME_INDEX = 0;
	private final static String PATTERN_ERROR_MESSAGE = "[ERROR] 패턴에 맞게 상품 정보를 입력해주세요.\n예) [콜라,1500,20];[사이다,1000,10]";
	private final static String MIN_PRICE_ERROR_MESSAGE = "[ERROR] 상품 가격은 100원 이상이어야합니다.";
	private final static String DIVIDE_BY_10_ERROR_MESSAGE = "[ERROR] 상품 가격은 10으로 나누어 떨어져야합니다.";
	private final static String NAME_DUPLICATE_ERROR_MESSAGE = "[ERROR] 상품명은 중복될 수 없습니다.";

	private static final List<List<String>> items = new ArrayList<>();
	private static final HashSet<String> itemNames = new HashSet<>();

	private InputItemValidator() {
	}

	public static boolean isValidated(String inputItem) {
		try {
			checkPattern(inputItem);
			setItems(inputItem);
			checkMinPrice();
			checkPriceDivideBy10();
			checkNameDuplicate();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private static void checkPattern(String inputItem) {
		if (!inputItem.matches(INPUT_ITEM_PATTERN)) {
			throw new IllegalArgumentException(PATTERN_ERROR_MESSAGE);
		}
	}

	private static void setItems(String inputItem) {
		String[] itemStrings = inputItem.split(INPUT_ITEM_SPLIT_REGEX);
		for (String itemString : itemStrings) {
			itemString = itemString.replace(REPLACE_TARGET_LEFT, "").replace(REPLACE_TARGET_RIGHT, "");
			items.add(Arrays.asList(itemString.split(SPLIT_REGEX)));
		}
	}

	private static void checkMinPrice() {
		for (List<String> item : items) {
			if (Integer.parseInt(item.get(PRICE_INDEX)) < MIN_PRICE) {
				throw new IllegalArgumentException(MIN_PRICE_ERROR_MESSAGE);
			}
		}
	}

	private static void checkPriceDivideBy10() {
		for (List<String> item : items) {
			if (Integer.parseInt(item.get(PRICE_INDEX)) % DIVIDE_BY_10 != 0) {
				throw new IllegalArgumentException(DIVIDE_BY_10_ERROR_MESSAGE);
			}
		}
	}

	private static void checkNameDuplicate() {
		for (List<String> item : items) {
			if (itemNames.contains(item.get(NAME_INDEX))) {
				throw new IllegalArgumentException(NAME_DUPLICATE_ERROR_MESSAGE);
			}
			else {
				itemNames.add(item.get(NAME_INDEX));
			}
		}
	}
}
