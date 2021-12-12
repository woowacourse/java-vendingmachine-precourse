package vendingmachine.utils.validator;

import static vendingmachine.utils.Error.*;

import java.util.List;

import vendingmachine.domain.Items;

public class ItemNameValidator {

	public static void validateItem(Items items, String itemName) {
		validateStatus(items, itemName);
	}

	private static void validateStatus(Items items, String itemName) {
		List<String> names = items.getNames();

		if (!names.contains(itemName)) {
			throw new IllegalArgumentException(ITEM_NOT_EXIST_ERROR);
		}
	}
}
