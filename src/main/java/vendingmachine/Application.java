package vendingmachine;

import vendingmachine.controller.VendingmachineController;

public class Application {
	public static void main(String[] args) {

		VendingmachineController vendingmachineController = new VendingmachineController();
		vendingmachineController.operate();
	}
}
