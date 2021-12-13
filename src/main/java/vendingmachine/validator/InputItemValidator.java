package vendingmachine.validator;

import java.util.Arrays;
import java.util.List;

public class InputItemValidator {
	private static final String INPUT_ITEM_SPLIT_REGEX = ";";
	private static final int ITEMS_MIN_SIZE = 1;
	private static final String ITEMS_SIZE_ERROR_MESSAGE = "[ERROR] 1개 이상의 상품을 입력해주세요.";

	private static List<String> items;

	private InputItemValidator() {
	}

	public static boolean isValidated(String inputItem) {
		try {
			setItems(inputItem);
			checkItemsSize();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private static void setItems(String inputItem) {
		items = Arrays.asList(inputItem.split(INPUT_ITEM_SPLIT_REGEX));
	}

	private static void checkItemsSize() {
		if (items.size() < ITEMS_MIN_SIZE) {
			throw new IllegalArgumentException(ITEMS_SIZE_ERROR_MESSAGE);
		}
	}
}
