package vendingmachine;

import vendingmachine.controller.MachineController;

public class VendingMachine {
	private MachineController machineController = new MachineController();

	public void run() {
		machineController.setupVendingMachine();
	}
}
