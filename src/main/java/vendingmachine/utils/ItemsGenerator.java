package vendingmachine.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.Item;
import vendingmachine.domain.Items;

public class ItemsGenerator {
	private static final String ENTIRE_DELIMETER = ";";
	private static final String PARTIAL_DELIMETER = ",";
	private static final int NAME_INDEX = 0;
	private static final int PRICE_INDEX = 1;
	private static final int AMOUNT_INDEX = 2;

	public static Items generateItems(String itemsInput) {
		List<Item> items = new ArrayList<>();

		Arrays.asList(itemsInput.split(ENTIRE_DELIMETER)).stream()
			.map(item -> item.substring(1, item.length() - 1))
			.forEach(item -> items.add(generateItem(item)));

		return new Items(items);
	}

	private static Item generateItem(String item) {
		String[] input = item.split(PARTIAL_DELIMETER);

		String itemName = input[NAME_INDEX];
		int itemPrice = parseItemPrice(input[PRICE_INDEX]);
		int itemAmount = parseItemAmount(input[AMOUNT_INDEX]);

		return new Item(itemName, itemPrice, itemAmount);
	}

	private static int parseItemAmount(String amount) {
		ItemsValidation.validateItemAmount(amount);
		return Integer.parseInt(amount);
	}

	private static int parseItemPrice(String price) {
		ItemsValidation.validateItemPrice(price);
		return Integer.parseInt(price);
	}
}
