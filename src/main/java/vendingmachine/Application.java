package vendingmachine;

import vendingmachine.controller.VendingMachineController;

public class Application {
	public static void main(String[] args) {
		VendingMachineController controller = new VendingMachineController();
		controller.play();
	}
}
