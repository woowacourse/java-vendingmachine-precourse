package vendingmachine.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.dto.ItemDto;
import vendingmachine.dto.ItemNameDto;
import vendingmachine.exception.ItemInputFormatException;
import vendingmachine.service.ItemsService;
import vendingmachine.service.UserBalanceService;
import vendingmachine.utils.StringUtils;
import vendingmachine.validator.ItemValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ItemsController {
	private static final String ITEM_DELIMITER = ";";
	private static final String ELEMENT_DELIMITER = ",";
	private static final String OPEN_BRACKET = "[";
	private static final String CLOSE_BRACKET = "]";
	private static final String BLANK_CHAR = "";

	private static final int ITEM_NAME_INDEX = 0;
	private static final int ITEM_PRICE_INDEX = 1;
	private static final int ITEM_QUANTITY_INDEX = 2;

	private final ItemsService itemsService = ItemsService.getInstance();
	private final UserBalanceService userBalanceService = UserBalanceService.getInstance();

	public void generateItems() {
		String input = InputView.inputItems();
		try {
			ItemValidator.validateItemsDuplication(input);
			createItemsByInput(input);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			generateItems();
		}
	}

	private void createItemsByInput(String input) {
		List<ItemDto> itemDtos = parseItemsInput(input);
		for (ItemDto itemDto : itemDtos) {
			itemsService.createItem(itemDto);
		}
	}

	private List<ItemDto> parseItemsInput(String itemsInput) {
		return Arrays.stream(itemsInput.split(ITEM_DELIMITER))
			.map(this::parseItemInput)
			.collect(Collectors.toList());
	}

	private ItemDto parseItemInput(String itemInput) {
		String parsedItemInput = itemInput.replace(OPEN_BRACKET, BLANK_CHAR).replace(CLOSE_BRACKET, BLANK_CHAR);
		String[] elements = parsedItemInput.split(ELEMENT_DELIMITER);

		String itemName = elements[ITEM_NAME_INDEX];
		String itemPrice = elements[ITEM_PRICE_INDEX];
		String itemQuantity = elements[ITEM_QUANTITY_INDEX];

		if (!StringUtils.isNumeric(itemPrice) || !StringUtils.isNumeric(itemQuantity)) {
			throw new ItemInputFormatException();
		}

		return ItemDto.of(itemName, Integer.parseInt(itemPrice), Integer.parseInt(itemQuantity));
	}

	public void buyItem() {
		String input = InputView.inputItemToBuy();
		ItemNameDto itemNameDto = ItemNameDto.from(input);
		try {
			itemsService.buyItem(itemNameDto);
			UserBalance userBalance = userBalanceService.getUserBalance();
			OutputView.printCurrentUserBalance(userBalance.toInt());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			buyItem();
		}
	}

	public boolean checkAvailableToPurchase() {
		int userBalance = userBalanceService.getUserBalance().toInt();

		boolean soldOut = itemsService.checkAllItemsSoldOut();
		boolean isUserBalanceNotEnough = userBalance < itemsService.getMinItemPrice().toInt();

		return !soldOut && !isUserBalanceNotEnough;
	}
}
