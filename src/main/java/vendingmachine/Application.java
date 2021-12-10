package vendingmachine;

import vendingmachine.machine.VendingMachineController;
import vendingmachine.machine.VendingMachineMaker;

public class Application {
	public static void main(String[] args) {
		VendingMachineMaker vendingMachineMaker = new VendingMachineMaker();
		VendingMachineController vendingMachineController = new VendingMachineController(vendingMachineMaker.setUp());
		vendingMachineController.use();
	}
}
