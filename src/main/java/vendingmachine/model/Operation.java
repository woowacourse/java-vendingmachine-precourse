package vendingmachine.model;

import vendingmachine.controller.BalanceController;
import vendingmachine.view.BalanceMessage;

public class Operation {

	public static void turnOn() {
		BalanceMessage.print();
		int balance = BalanceController.getInputValue();
	}
}
