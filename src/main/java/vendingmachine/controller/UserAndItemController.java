package vendingmachine.controller;

import vendingmachine.models.ItemList;
import vendingmachine.models.User;
import vendingmachine.view.ItemChoiceInputView;

public class UserAndItemController {
	public static void buy(User user, ItemList itemList) {
		boolean endBuy = false;
		while (!endBuy) {
			endBuy = isValidBuying(user, itemList);
		}
	}

	private static boolean isValidBuying(User user, ItemList itemList) {
		String itemInput = new ItemChoiceInputView().getInput();
		try {
			itemList.sellItem(itemInput, user.getPayMoney());
			user.decreasePayMoney(itemList.getItemPrice(itemInput));
			return true;
		} catch (IllegalArgumentException error) {
			System.out.print(error.getMessage());
			return false;
		}
	}
}
