package vendingmachine.model;

import vendingmachine.util.OrderException;

public class Order {
	public static int takeOrder(VendingMachine vendingMachine, String orderedMenu) {
		int cost;
		cost = OrderException.checkCanTakeThisOrder(orderedMenu, vendingMachine);
		return cost;
	}

}
