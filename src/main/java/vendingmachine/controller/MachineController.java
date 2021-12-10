package vendingmachine.controller;

import vendingmachine.view.InputView;

public class MachineController {
	public static void askHoldingAmount() {
		try {
			InputView.askHoldingAmount();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			askHoldingAmount();
		}
	}
}
