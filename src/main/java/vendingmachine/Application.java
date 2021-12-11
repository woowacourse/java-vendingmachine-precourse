package vendingmachine;

import vendingmachine.Controller.MachineController;
import vendingmachine.Model.VendingMachine;

public class Application {
	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		MachineController machineController = new MachineController(vendingMachine);
		machineController.operate();
	}
}
