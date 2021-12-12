package vendingmachine.utils.validator;

import static vendingmachine.utils.Error.*;

import java.util.List;

import vendingmachine.domain.Items;

public class ItemNameValidator {

	private static final int OUT_OF_STOCK = 0;

	public static void validateItem(Items items, String itemName) {
		validateStatus(items, itemName);
		validateStock(items, itemName);
	}

	private static void validateStatus(Items items, String itemName) {
		List<String> names = items.getNames();

		if (!names.contains(itemName)) {
			throw new IllegalArgumentException(ITEM_NOT_EXIST_ERROR);
		}
	}

	private static void validateStock(Items items, String itemName) {
		int quantity = items.getStockByName(itemName);

		if (quantity == OUT_OF_STOCK) {
			throw new IllegalArgumentException(ITEM_NOT_STOCK_ERROR);
		}
	}
}
