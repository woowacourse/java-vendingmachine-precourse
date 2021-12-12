package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.RandomGenerator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

	public static void run() {
		VendingMachine vendingMachine = new VendingMachine(
			RandomGenerator.getHoldingCoin((InputView.getHoldingAmount())));
		OutputView.inputHoldingCoin(vendingMachine.getHoldingCoin());
		InputView.getProducts();
		
	}
}
