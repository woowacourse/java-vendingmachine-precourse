package vendingmachine.service;

import vendingmachine.view.InputView;

public class PurchaseService {

	private InputView inputView;

	public PurchaseService() {
		inputView = new InputView();
	}

	public int purchaseItem() {
		String itemName = inputView.inputItemName();
	}

}
