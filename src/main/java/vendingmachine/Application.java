package vendingmachine;

import vendingmachine.controller.VendingmachineController;
import vendingmachine.model.Vendingmachine;

public class Application {
	public static void main(String[] args) {

		Vendingmachine vendingmachine = new Vendingmachine();
		VendingmachineController vendingmachineController = new VendingmachineController(vendingmachine);
		vendingmachineController.operate();
	}
}
