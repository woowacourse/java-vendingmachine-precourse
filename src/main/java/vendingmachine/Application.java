package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.model.VendingMachine;

public class Application {
	public static void main(String[] args) {

		VendingMachine vendingMachine = new VendingMachine();
		VendingMachineController vendingMachineController = new VendingMachineController(vendingMachine);
		vendingMachineController.operate();
	}
}
