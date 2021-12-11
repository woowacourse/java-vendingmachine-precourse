package vendingmachine.service.validator;

import java.util.List;

import vendingmachine.domain.Item;

public class PurchaseInputValidator {

	public void validateItemName(String itemName, List<Item> items) {
		try {
			isExistsItem(itemName, items);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}

	}

	private void isExistsItem(String itemName, List<Item> items) {
		boolean isContainItem = items.stream()
			.map(Item::getName)
			.anyMatch(name -> name.equals(itemName));
		if (!isContainItem) {
			throw new IllegalArgumentException("존재하지 않는 상품명입니다.");
		}
	}
}
