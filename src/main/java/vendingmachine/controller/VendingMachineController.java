package vendingmachine.controller;

import vendingmachine.validator.AmountValidator;
import vendingmachine.view.InputView;

public class VendingMachineController {
	public void getVendingMachineAmount() {
		try {
			String amount = InputView.getVendingMachineAmount();
			AmountValidator.checkVendingMachineAmount(amount);
			System.out.println(amount);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			getVendingMachineAmount();
		}
	}
}
