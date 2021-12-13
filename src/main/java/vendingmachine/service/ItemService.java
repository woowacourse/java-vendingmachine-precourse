package vendingmachine.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Item;
import vendingmachine.service.validator.ItemInputValidator;
import vendingmachine.view.InputView;

public class ItemService {

	private ItemInputValidator itemInputValidator;
	private InputView inputView;
	private static final String ITEM_DELIMITER = ";";
	public static final String ELEMENT_DELIMITER = ",";
	private static final int ITEM_NAME_INDEX = 0;
	private static final int ITEM_PRICE_INDEX = 1;
	private static final int ITEM_QUANTITY_INDEX = 2;

	public ItemService() {
		itemInputValidator = new ItemInputValidator();
		inputView = new InputView();
	}

	public List<Item> getItems() {
		boolean isValid;
		List<String> splitItemList;
		do {
			String itemInput = inputView.getItemInput();
			splitItemList = Arrays.asList(itemInput.split(ITEM_DELIMITER));
			isValid = validateItem(splitItemList);
		} while (!isValid);

		return splitItemList.stream()
			.map(itemString -> splitItem(itemString))
			.collect(Collectors.toList());
	}

	private boolean validateItem(List<String> splitItemList) {
		return splitItemList.stream()
			.map(itemInputString -> itemInputValidator.validateItemInput(itemInputString))
			.allMatch(bool -> bool == true);
	}

	public boolean isEnoughQuantityForItems(List<Item> items) {
		return !items.stream()
			.allMatch(item -> item.isEnoughQuantity() == false);
	}

	private Item splitItem(String itemString) {
		String itemWithoutBrackets = itemInputValidator.deleteBrackets(itemString);
		List<String> elementList = Arrays.asList(itemWithoutBrackets.split(ELEMENT_DELIMITER));
		String itemName = elementList.get(ITEM_NAME_INDEX);
		int price = Integer.parseInt(elementList.get(ITEM_PRICE_INDEX));
		int quantity = Integer.parseInt(elementList.get(ITEM_QUANTITY_INDEX));
		return new Item(itemName, price, quantity);
	}

}
