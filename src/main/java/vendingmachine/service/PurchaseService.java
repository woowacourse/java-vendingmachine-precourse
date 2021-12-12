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

	public int purchaseItem(List<Item> items, int remainingMoney) {
		Item item = getItem(items, remainingMoney);
		item.reduceQuantity();
		return remainingMoney - item.getPrice();
	}

	private Item getItem(List<Item> items, int remainingMoney) {
		boolean isValidItem;
		String itemName;
		Item selectedItem;
		do {
			itemName = inputView.inputItemName();
			String finalItemName = itemName;
			selectedItem = items.stream()
				.filter(item -> item.isEqualItemByName(finalItemName) == true)
				.findAny()
				.orElse(null);
			isValidItem = purchaseInputValidator.validateItem(selectedItem, remainingMoney);
		} while (!isValidItem);
		return selectedItem;
	}

}
