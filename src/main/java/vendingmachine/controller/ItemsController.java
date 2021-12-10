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

	public boolean checkAvailablePurchasing() {
		// TODO: 자판기 잔여금액이 상품의 최저 가격보다 적음을 판단하는 로직 추가
		boolean soldOut = itemsService.checkSoldOut();
		return !soldOut;
	}
}
