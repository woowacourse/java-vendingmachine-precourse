package vendingmachine.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.dto.ItemDto;
import vendingmachine.exception.NotNumericException;

public class ItemsInputParser {
	private static final String ITEM_DELIMITER = ";";
	private static final String ELEMENT_DELIMITER = ",";
	private static final String OPEN_BRACKET = "[";
	private static final String CLOSE_BRACKET = "]";
	private static final String BLANK_CHAR = "";

	private static final int ITEM_NAME_INDEX = 0;
	private static final int ITEM_PRICE_INDEX = 1;
	private static final int ITEM_QUANTITY_INDEX = 2;

	public static List<ItemDto> mapToDtos(String itemsInput) {
		return parseItems(itemsInput).stream()
			.map(ItemsInputParser::parseItemInput)
			.collect(Collectors.toList());
	}

	private static List<String> parseItems(String itemsInput) {
		return Arrays.asList(itemsInput.split(ITEM_DELIMITER));
	}

	private static ItemDto parseItemInput(String itemInput) {
		String parsedItemInput = itemInput.replace(OPEN_BRACKET, BLANK_CHAR).replace(CLOSE_BRACKET, BLANK_CHAR);
		String[] elements = parsedItemInput.split(ELEMENT_DELIMITER);

		String itemName = elements[ITEM_NAME_INDEX];
		String itemPrice = elements[ITEM_PRICE_INDEX];
		String itemQuantity = elements[ITEM_QUANTITY_INDEX];

		if (!StringUtils.isNumeric(itemPrice) || !StringUtils.isNumeric(itemQuantity)) {
			throw new NotNumericException();
		}

		return ItemDto.of(itemName, Integer.parseInt(itemPrice), Integer.parseInt(itemQuantity));
	}
}
