package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.controller.ViewController;

public class Application {

	public static void main(String[] args) {
		ViewController viewController = new ViewController();
		VendingMachineController vendingMachineController = new VendingMachineController(viewController);

		vendingMachineController.init();
		vendingMachineController.run();
	}
}
