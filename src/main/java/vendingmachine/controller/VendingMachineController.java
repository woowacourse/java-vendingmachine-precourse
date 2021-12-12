package vendingmachine.controller;

import vendingmachine.view.InputView;

public class VendingMachineController {
	public void getVendingMachineAmount() {
		String amount = InputView.getVendingMachineAmount();
		System.out.println(amount);
	}
}
