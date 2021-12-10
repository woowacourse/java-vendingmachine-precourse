package vendingmachine.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Item;
import vendingmachine.service.validator.ItemInputValidator;

public class ItemService {

	private ItemInputValidator itemInputValidator;
	private static final String ITEM_DELIMITER = ";";
	private static final int ITEM_NAME_INDEX = 0;
	private static final int ITEM_PRICE_INDEX = 1;
	private static final int ITEM_QUANTITY_INDEX = 2;

	public ItemService() {
		itemInputValidator = new ItemInputValidator();
	}

	public List<Item> getItems(String itemInput) {
		List<String> splitItemList = Arrays.asList(itemInput.split(ITEM_DELIMITER));
		splitItemList.stream()
			.forEach(itemString -> itemInputValidator.validateItemInput(itemString));

		return splitItemList.stream()
			.map(itemString -> splitItem(itemString))
			.collect(Collectors.toList());
	}

	private Item splitItem(String itemString) {
		String itemWithoutBrackets = itemInputValidator.deleteBrackets(itemString);
		List<String> elementList = Arrays.asList(itemWithoutBrackets.split(","));
		String itemName = elementList.get(ITEM_NAME_INDEX);
		int price = Integer.parseInt(elementList.get(ITEM_PRICE_INDEX));
		int quantity = Integer.parseInt(elementList.get(ITEM_QUANTITY_INDEX));
		return new Item(itemName, price, quantity);
	}

}
