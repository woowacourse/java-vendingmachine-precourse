package vendingmachine.Controller;

import vendingmachine.Controller.Run.Activate;
import vendingmachine.Controller.Run.Change;
import vendingmachine.Model.VendingMachine;

public class MachineController {
	public VendingMachine vendingMachine;

	public MachineController(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void operate() {
		vendingMachine.init();
		new Activate(vendingMachine);
		new Change(vendingMachine);
	}
}
