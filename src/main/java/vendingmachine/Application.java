package vendingmachine;

import vendingmachine.Controller.MachineController;
import vendingmachine.Model.VendingMachine;

public class Application {
	public static void main(String[] args) {
		new MachineController(new VendingMachine()).operate();
	}
}
