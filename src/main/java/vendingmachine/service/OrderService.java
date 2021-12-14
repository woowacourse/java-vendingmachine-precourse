package vendingmachine.service;

import static vendingmachine.utils.View.showErrorMessage;

import vendingmachine.domain.Item;
import vendingmachine.domain.Items;

public class OrderService {
	private final UserService userService = new UserService();

	public int orderItem(Items forSaleItems, int userMoney) {
		while (true) {
			try {
				String orderItemName = userService.getPurchasingItemName(forSaleItems.getForSaleItemsList(), userMoney);
				Item orderItem = forSaleItems.findItemByName(orderItemName);

				return orderItem.order(userMoney);
			} catch (IllegalArgumentException e) {
				showErrorMessage(e.getMessage());
			}
		}
	}

	public boolean canPurchaseAnyItems(int userMoney, Items forSaleItems) {
		return forSaleItems.checkCanPurchaseAtLeastOneItem(userMoney);
	}
}
