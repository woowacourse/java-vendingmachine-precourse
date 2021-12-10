package vendingmachine.controller;

import vendingmachine.domain.Items.Items;
import vendingmachine.service.ItemsService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ItemsController {
	private final ItemsService itemsService = ItemsService.getInstance();

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
}
