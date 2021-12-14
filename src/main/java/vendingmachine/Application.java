package vendingmachine;

import vendingmachine.view.VendingMachine;
import vendingmachine.view.classes.VendingMachineUI;

public class Application {
	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachineUI();
		vendingMachine.start();
	}
}
