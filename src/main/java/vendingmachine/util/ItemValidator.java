package vendingmachine.util;

import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.Item;
import vendingmachine.view.ErrorMessage;

public class ItemValidator {

	public static final String ITEM_SEPARATOR = ";";
	public static final String ITEM_FORM = "^\\[[a-zA-Z가-힣]+,[1-9][0-9]+0,[1-9][0-9]*]$";

	public static void validateItemForm(String inputString) {
		Arrays.stream(inputString.split(ITEM_SEPARATOR))
			.filter(str -> !str.matches(ITEM_FORM))
			.findAny()
			.ifPresent(str -> {
				throw new IllegalArgumentException(ErrorMessage.WRONG_ITEM_INPUT);
			});
	}

	public static Item validateAvailability(List<Item> itemList, String inputString) {
		Item item = validateItemForm(itemList, inputString);
		validateQuantity(item);
		return item;
	}

	private static Item validateItemForm(List<Item> itemList, String inputString) {
		return itemList.stream()
			.filter(item -> item.getItemName().equals(inputString))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.CANNOT_FIND_ITEM));
	}

	private static void validateQuantity(Item item) {
		if (item.getQuantity() == 0) {
			throw new IllegalArgumentException(ErrorMessage.SOLD_OUT);
		}
	}
}
