package vendingmachine;

import vendingmachine.controller.VendingMachineController;

public class Application {
	private static final VendingMachineController controller = new VendingMachineController();

	public static void main(String[] args) {
		settingVendingMachine();
		operateMachine();
	}

	private static void settingVendingMachine() {
		controller.settingMachineChanges();
		controller.settingMerchandise();
	}

	private static void operateMachine() {
		controller.putMoneyIntoMachine();
		controller.chooseUntilReturnBalance();
	}
}
