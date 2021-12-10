package vendingmachine.controller;

import vendingmachine.domain.item.Item;
import vendingmachine.domain.item.ItemName;
import vendingmachine.domain.items.Items;
import vendingmachine.domain.userbalance.UserBalance;
import vendingmachine.service.ItemsService;
import vendingmachine.service.UserBalanceService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ItemsController {
	private final ItemsService itemsService = ItemsService.getInstance();
	private final UserBalanceService userBalanceService = UserBalanceService.getInstance();

	public void generateItems() {
		String input = InputView.inputItems();
		try {
			Items items = Items.from(input);
			itemsService.initItems(items);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			generateItems();
		}
	}

	// TODO: 리팩토링 필요
	public void buyItem() {
		String input = InputView.inputItemToBuy();
		try {
			ItemName itemName = ItemName.from(input);
			Item item = itemsService.findByItemName(itemName);
			UserBalance userBalance = userBalanceService.getUserBalance();
			itemsService.buyItem(item, userBalance);
			userBalanceService.subtractUserBalance(item.getItemPrice());
			userBalance = userBalanceService.getUserBalance();
			OutputView.printCurrentUserBalance(userBalance.toInt());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			buyItem();
		}
	}

	public boolean checkAvailableToPurchase() {
		int userBalance = userBalanceService.getUserBalance().toInt();

		boolean soldOut = itemsService.checkSoldOut();
		boolean isUserBalanceNotEnough = userBalance < itemsService.getMinItemPrice().toInt();

		return !soldOut && !isUserBalanceNotEnough;
	}

}
