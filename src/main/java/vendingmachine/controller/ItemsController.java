package vendingmachine.controller;

import java.util.List;

import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.dto.ItemDto;
import vendingmachine.dto.ItemNameDto;
import vendingmachine.service.ItemsService;
import vendingmachine.service.UserBalanceService;
import vendingmachine.utils.ItemsInputParser;
import vendingmachine.validator.ItemValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ItemsController {
	private final ItemsService itemsService = ItemsService.getInstance();
	private final UserBalanceService userBalanceService = UserBalanceService.getInstance();

	public void generateItems() {
		String input = InputView.inputItems();
		try {
			ItemValidator.validateItemsDuplication(input);
			List<ItemDto> itemDtos = ItemsInputParser.mapToDtos(input);
			createItemsByDtos(itemDtos);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			generateItems();
		}
	}

	private void createItemsByDtos(List<ItemDto> itemDtos) {
		for (ItemDto itemDto : itemDtos) {
			itemsService.createItem(itemDto);
		}
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
