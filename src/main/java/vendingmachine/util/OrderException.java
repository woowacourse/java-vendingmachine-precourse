package vendingmachine.util;

import vendingmachine.constants.ErrorMessage;
import vendingmachine.model.VendingMachine;

public class OrderException {
	public static int checkCanTakeThisOrder(String order, VendingMachine vendingMachine) {
		int cost;
		try {
			isThereThisMenu(order, vendingMachine);
			isThereAnyQuantity(order, vendingMachine);
			cost = checkCanBuyThisProductWithRemainMoney(order, vendingMachine);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return cost;
	}

	public static void isThereThisMenu(String order, VendingMachine vendingMachine) {

		if (!vendingMachine.findMenu(order)) {
			throw new IllegalArgumentException(ErrorMessage.NO_NAME_IN_MENU_MESSAGE);
		}

	}

	public static void isThereAnyQuantity(String order, VendingMachine vendingMachine) {

		if (!vendingMachine.findQuantityOfOrder(order)) {
			throw new IllegalArgumentException(ErrorMessage.NO_QUANTITY_MESSAGE);
		}

	}

	public static int checkCanBuyThisProductWithRemainMoney(String order, VendingMachine vendingMachine) {
		int cost = vendingMachine.comparePrice(order);
		if (cost == 0) {
			throw new IllegalArgumentException(ErrorMessage.CANNOT_BUY_WITH_REMAIN_MESSAGE);
		}

		return cost;
	}

}
