package vendingmachine.utils.validator;

import static vendingmachine.utils.Error.*;

import java.util.List;

import vendingmachine.domain.Item;
import vendingmachine.domain.Items;

public class ItemNameValidator {

	public static void validateItem(Items items, String itemName, int amount) {
		validateStatus(items, itemName);
		validateLackAmount(items, itemName, amount);
	}

	private static void validateStatus(Items items, String itemName) {
		List<String> names = items.getNames();

		if (!names.contains(itemName)) {
			throw new IllegalArgumentException(ITEM_NOT_EXIST_ERROR);
		}
	}

	private static void validateLackAmount(Items items, String itemName, int amount) {
		Item item = items.findByName(itemName);

		if (!item.checkPurchase(amount)) {
			throw new IllegalArgumentException(ITEM_NOT_PURCHASE_ERROR);
		}
	}
}
