package vendingmachine.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.dto.ItemDto;
import vendingmachine.exception.ItemEmptyException;
import vendingmachine.exception.NotNumericException;
import vendingmachine.validator.ItemValidator;

public class ItemsInputParser {
	private static final String ITEM_DELIMITER = ";";
	private static final String ELEMENT_DELIMITER = ",";
	private static final String OPEN_BRACKET = "[";
	private static final String CLOSE_BRACKET = "]";
	private static final String BLANK_CHAR = "";

	private static final int ITEM_EMPTY_QUANTITY = 0;

	private static final int ITEM_NAME_INDEX = 0;
	private static final int ITEM_PRICE_INDEX = 1;
	private static final int ITEM_QUANTITY_INDEX = 2;

	public static List<ItemDto> mapToDtos(String itemsInput) {
		return parseItems(itemsInput).stream()
			.map(ItemsInputParser::parseItemInput)
			.collect(Collectors.toList());
	}

	private static List<String> parseItems(String itemsInput) {
		List<String> splittedItems = Arrays.asList(itemsInput.split(ITEM_DELIMITER));
		if (splittedItems.size() <= ITEM_EMPTY_QUANTITY) {
			throw new ItemEmptyException();
		}

		return splittedItems;
	}

	private static ItemDto parseItemInput(String itemInput) {
		ItemValidator.validateItemInputFormat(itemInput);

		List<String> elements = getElementsFromItemInput(itemInput);
		validateItemElements(elements);

		return ItemDto.of(
			elements.get(ITEM_NAME_INDEX),
			Integer.parseInt(elements.get(ITEM_PRICE_INDEX)),
			Integer.parseInt(elements.get(ITEM_QUANTITY_INDEX))
		);
	}

	private static List<String> getElementsFromItemInput(String itemInput) {
		return Arrays.asList(
			itemInput.replace(OPEN_BRACKET, BLANK_CHAR)
				.replace(CLOSE_BRACKET, BLANK_CHAR)
				.split(ELEMENT_DELIMITER)
		);
	}

	private static void validateItemElements(List<String> elements) {
		boolean isItemPriceNumeric = StringUtils.isNumeric(elements.get(ITEM_PRICE_INDEX));
		boolean isItemQuantityNumeric = StringUtils.isNumeric(elements.get(ITEM_QUANTITY_INDEX));
		if (!isItemPriceNumeric || !isItemQuantityNumeric) {
			throw new NotNumericException();
		}
	}
}
