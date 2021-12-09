package vendingmachine;

import vendingmachine.controller.VendingMachineInputController;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		int vendingMachineAccount = VendingMachineInputController.getAccount();
		System.out.println("vendingMachineAccount = " + vendingMachineAccount);

	}
}
