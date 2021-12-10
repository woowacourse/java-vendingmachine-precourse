package vendingmachine.util;

import vendingmachine.constants.ErrorMessage;
import vendingmachine.model.VendingMachine;

public class OrderException {
	public static void checkCanTakeThisOrder(String order, VendingMachine vendingMachine) {
		try {
			isThereThisMenu(order, vendingMachine);
			isThereAnyQuantity(order, vendingMachine);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
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

	public static void checkCanBuyThisProductWithRemainMoney(String order, VendingMachine vendingMachine) {

		if (vendingMachine.comparePrice(order)) {
			throw new IllegalArgumentException(ErrorMessage.CANNOT_BUY_WITH_REMAIN_MESSAGE);
		}

	}
}
