package vendingmachine.utils.validator;

import static vendingmachine.utils.Error.*;
import static vendingmachine.utils.validator.AmountValidator.*;
import static vendingmachine.utils.Message.*;

import java.util.ArrayList;
import java.util.List;

public class ItemValidator {

	private static final String ITEM_PATTERN = "(\\[[a-zA-Z0-9가-힣]+,\\d+,\\d+])(;\\[[a-zA-Z0-9가-힣]+,\\d+,\\d+])*$";
	private static final int NAME = 0;
	private static final int PRICE = 1;
	private static final int QUANTITY = 2;

	public static void validateItemList(String itemList) {
		validateFormat(itemList);
		validateItems(itemList);
	}

	private static void validateFormat(String itemList) {
		if (!itemList.matches(ITEM_PATTERN)) {
			throw new IllegalArgumentException(ITEM_NOT_FORMAT_ERROR);
		}
	}

	private static void validateItems(String itemList) {
		String[] separatedItems = itemList.split(ITEM_SEPARATOR);
		List<String> names = new ArrayList<>();
		for (String item : separatedItems) {
			names.add(validateElements(item));
		}
		validateName(names);
	}

	private static String validateElements(String item) {
		String[] separatedElements = processElements(item);
		validateAmount(separatedElements[PRICE], PRICE);
		validateQuantity(separatedElements[QUANTITY]);
		return separatedElements[NAME];
	}

	private static String[] processElements(String item) {
		String processedElements = item.substring(1, item.length() - 1);
		return processedElements.split(ITEM_ELEMENT_SEPARATOR);
	}

	private static void validateQuantity(String quantity) {
		if (Integer.parseInt(quantity) == 0) {
			throw new IllegalArgumentException(ZERO_QUANTITY_ERROR);
		}
	}

	private static void validateName(List<String> names) {
		long count = names.stream()
			.distinct()
			.count();

		if (names.size() != count) {
			throw new IllegalArgumentException(ITEM_DUPLICATE_ERROR);
		}
	}
}
