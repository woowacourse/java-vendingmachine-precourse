package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public void run() {
		VendingMachine vendingMachine = new VendingMachine();

		initializeCoins(vendingMachine);
		OutputView.showCoins(vendingMachine);
		initializeItems(vendingMachine);
		initializeBalance(vendingMachine);

		while (vendingMachine.isAvailable()) {
			OutputView.showBalance(vendingMachine);
			executePurchase(vendingMachine);
		}
		OutputView.showBalance(vendingMachine);
		OutputView.showChanges(vendingMachine);
	}

	private void initializeCoins(VendingMachine vendingMachine) {
		String coinBalance = InputView.setCoins();
		try {
			vendingMachine.initializeCoins(coinBalance);
		} catch (IllegalArgumentException e) {
			OutputView.showError(e.getMessage());
			initializeCoins(vendingMachine);
		}
	}
}
