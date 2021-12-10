package vendingmachine.util;

import vendingmachine.constants.ErrorMessage;
import vendingmachine.model.VendingMachine;

public class OrderException {
	public static void checkCanTakeThisOrder(String order, VendingMachine vendingMachine) {
		try {
			isThereThisMenu(order, vendingMachine);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	public static void isThereThisMenu(String order, VendingMachine vendingMachine) {

		if (!vendingMachine.findMenu(order)) {
			throw new IllegalArgumentException(ErrorMessage.NO_NAME_IN_MENU_MESSAGE);
		}

	}

}
