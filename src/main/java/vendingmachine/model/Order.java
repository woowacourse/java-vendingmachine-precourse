package vendingmachine.model;

import vendingmachine.util.OrderException;

public class Order {
	public static int takeOrder(VendingMachine vendingMachine, String orderedMenu) {
		int cost;
		try {
			cost = OrderException.checkCanTakeThisOrder(orderedMenu, vendingMachine);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
		return cost;
	}

}
