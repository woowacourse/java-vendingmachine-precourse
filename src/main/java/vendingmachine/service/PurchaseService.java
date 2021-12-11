package vendingmachine.service;

import java.util.List;

import vendingmachine.domain.Item;
import vendingmachine.service.validator.PurchaseInputValidator;
import vendingmachine.view.InputView;

public class PurchaseService {

	private InputView inputView;
	private PurchaseInputValidator purchaseInputValidator;

	public PurchaseService() {
		inputView = new InputView();
		purchaseInputValidator = new PurchaseInputValidator();
	}

	public int purchaseItem(List<Item> items) {
		String itemName = inputView.inputItemName();
		purchaseInputValidator.validateItemName(itemName, items);
	}

}
