package vendingmachine.controller;

import vendingmachine.domain.Items.Items;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ItemsController {
	public void generateItems() {
		String input = InputView.inputItems();
		try {
			Items items = Items.from(input);
			// TODO: Service 호출 로직 추가
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			generateItems();
		}
	}
}
