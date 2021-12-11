package vendingmachine.service;

import java.util.List;
import java.util.Optional;

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

	public int purchaseItem(List<Item> items, int remainingMoney) {
		String itemName = inputView.inputItemName();
		Item selectedItem = items.stream()
			.filter(item -> item.getName().equals(itemName))
			.findAny()
			.orElse(null);
		purchaseInputValidator.validateItem(selectedItem, remainingMoney);
	}

}
