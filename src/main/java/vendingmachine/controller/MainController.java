package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;

public class MainController {
	public void run() {
		InputController inputController = new InputController();

		int changeAmount = Integer.parseInt(inputController.inputVendingMachinePrice());
		VendingMachine vendingMachine = new VendingMachine(changeAmount);

		vendingMachine.generateCoins();
	}
}
