package vendingmachine.service;

import vendingmachine.model.VendingMachine;
import vendingmachine.util.OrderException;

public class TakingOrderService {
	public static int takeOrder(VendingMachine vendingMachine, String orderedMenu) {
		int cost;
		cost = OrderException.checkCanTakeThisOrder(orderedMenu, vendingMachine);
		return cost;
	}

}
