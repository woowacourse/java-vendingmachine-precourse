package vendingmachine.model;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constants.ErrorMessage;
import vendingmachine.util.OrderException;

public class Order {
	public static int takeOrder(VendingMachine vendingMachine) {
		int cost;
		try {
			String orderedMenu = Console.readLine();
			cost = OrderException.checkCanTakeThisOrder(orderedMenu, vendingMachine);
		} catch (IllegalArgumentException e) {
			System.out.println(ErrorMessage.ERROR + e.getMessage());
			return takeOrder(vendingMachine);
		}
		return cost;
	}
	
}
